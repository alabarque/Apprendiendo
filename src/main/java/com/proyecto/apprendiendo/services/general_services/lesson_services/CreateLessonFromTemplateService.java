package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.general_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateLessonFromTemplateService {
    private CreateLessonService createLessonService;
    private CreateActivityService createActivityService;
    private CreateDocumentService createDocumentService;


    @Transactional(rollbackOn = Exception.class)
    public Long execute(LessonTemplateDTO lessonTemplateDTO, Long projectId) {
        LessonDTO lessonDTO = LessonMapper.templateDtoToDto(lessonTemplateDTO);
        lessonDTO.setProjectId(projectId);
        Long lessonId = createLessonService.execute(lessonDTO);
        lessonTemplateDTO.getActivities().forEach(activity -> {
            ActivityDTO activityDTO = ActivityMapper.templateDtoToDto(activity);
                activityDTO.setLessonId(lessonId);
                Long newActivityId = createActivityService.execute(activityDTO);
                activity.getDocuments().forEach(document -> {
                    createDocumentService.execute(DocumentMapper.templateDtoToDto(document, newActivityId, "ACTIVITY"));
                });
            });

        return lessonId;
    }
}
