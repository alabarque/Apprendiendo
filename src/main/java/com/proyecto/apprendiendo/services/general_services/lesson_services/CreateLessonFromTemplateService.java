package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityFromTemplateService;
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
    private CreateDocumentService createDocumentService;
    private CreateActivityFromTemplateService createActivityFromTemplateService;


    @Transactional(rollbackOn = Exception.class)
    public Long execute(LessonTemplateDTO lessonTemplateDTO, Long projectId) {
        LessonDTO lessonDTO = LessonMapper.templateDtoToDto(lessonTemplateDTO);
        lessonDTO.setProjectId(projectId);
        Long lessonId = createLessonService.execute(lessonDTO);

        if (lessonTemplateDTO.getDocuments() != null) {
            lessonTemplateDTO.getDocuments().forEach(document -> {
                createDocumentService.execute(DocumentMapper.templateDtoToDto(document, lessonId, "LESSON"));
            });
        }

        if (lessonTemplateDTO.getActivities() != null) {
            lessonTemplateDTO.getActivities().forEach(activity -> {
                createActivityFromTemplateService.execute(activity, lessonId);
            });
        }

        return lessonId;
    }
}
