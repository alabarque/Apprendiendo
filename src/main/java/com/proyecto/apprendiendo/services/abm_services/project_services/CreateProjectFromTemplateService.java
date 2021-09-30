package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
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
    private CreateProjectService createProjectService;
    private CreateLessonService createLessonService;
    private CreateActivityService createActivityService;
    private CreateDocumentService createDocumentService;


    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectTemplateDTO projectTemplateDTO, Long classroomId) {
        Long projectId = createProjectService.execute(ProjectMapper.templateToNew(projectTemplateDTO), classroomId);
        projectTemplateDTO.getLessons().forEach(lesson -> {
            LessonDTO lessonDTO = LessonMapper.templateDtoToDto(lesson);
            lessonDTO.setProjectId(projectId);
            Long newLessonId = createLessonService.execute(lessonDTO);
            lesson.getActivities().forEach(activity -> {
                ActivityDTO activityDTO = ActivityMapper.templateDtoToDto(activity);
                activityDTO.setLessonId(newLessonId);
                Long newActivityId = createActivityService.execute(activityDTO);
                activity.getDocuments().forEach(document -> {
                    createDocumentService.execute(DocumentMapper.templateDtoToNewDto(document, newActivityId, "ACTIVITY"));
                });
            });
        });

        return projectId;
    }
}
