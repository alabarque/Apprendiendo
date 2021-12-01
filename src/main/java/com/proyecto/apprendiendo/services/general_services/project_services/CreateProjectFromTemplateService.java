package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.general_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.CreateLessonFromTemplateService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.CreateLessonService;
import com.proyecto.apprendiendo.services.general_services.reward_services.CreateRewardFromTemplateService;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateProjectFromTemplateService {
    private CreateProjectService createProjectService;
    private CreateDocumentService createDocumentService;
    private CreateRewardFromTemplateService createRewardFromTemplateService;
    private CreateLessonFromTemplateService createLessonFromTemplateService;


    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectTemplateDTO projectTemplateDTO) {
        Long projectId = createProjectService.execute(ProjectMapper.templateToDto(projectTemplateDTO));

        if (projectTemplateDTO.getDocuments() != null) {
            projectTemplateDTO.getDocuments().forEach(document -> {
                createDocumentService.execute(DocumentMapper.templateDtoToDto(document, projectId, "PROJECT"));
            });
        }

        if (projectTemplateDTO.getRewards() != null) {
            projectTemplateDTO.getRewards().forEach(reward -> {
                createRewardFromTemplateService.execute(reward, projectId, "PROJECT");
            });
        }

        if (projectTemplateDTO.getLessons() != null) {
            projectTemplateDTO.getLessons().forEach(lesson -> {
                createLessonFromTemplateService.execute(lesson, projectId);
            });
        }

        return projectId;
    }
}
