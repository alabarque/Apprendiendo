package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.abm_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.CreateLessonService;
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
    private ProjectRepository projectRepository;
    private CreateProjectService createProjectService;
    private CreateLessonService createLessonService;
    private CreateActivityService createActivityService;
    private CreateDocumentService createDocumentService;



    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectTemplateDTO projectTemplateDTO) {
        Long projectId = createProjectService.execute(ProjectMapper.templateToNew(projectTemplateDTO), projectTemplateDTO.getClassroomId());
        projectTemplateDTO.getLessons().forEach(lesson -> {
            createLessonService.execute(LessonMapper.templateDtoToDto(lesson));
            lesson.getActivities().forEach(activity -> {
                createActivityService.execute(ActivityMapper.templateDtoToDto(activity));
                activity.getDocuments().forEach(document -> createDocumentService.execute(DocumentMapper.DtoToNewDto(document, activity.getId(), "ACTIVITY")));
            });
        });

        return projectId;
    }
}
