package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.general_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class CreateActivityService {

    private ActivityRepository activityRepository;
    private CreateDocumentService createDocumentService;

    public Long execute(ActivityDTO activityDTO) {
        Activity activity = Activity.builder()
                                    .name(activityDTO.getName())
                                    .description(activityDTO.getDescription())
                                    .position(activityDTO.getPosition())
                                    .lessonId(activityDTO.getLessonId())
                                    .startDate(activityDTO.getStartDate())
                                    .dueDate(activityDTO.getDueDate())
                                    .build();

        if (activityDTO.getStartDate() == null) activity.setStartDate(LocalDateTime.now());

        Long activityId = activityRepository.save(activity).getId();

        if(activityDTO.getDocuments() != null) {
            activityDTO.getDocuments().forEach(document -> createDocumentService.execute(DocumentMapper.templateDtoToDto(
                        DocumentTemplateDTO.builder()
                                .name(document.getName())
                                .position(document.getPosition())
                                .data(document.getData())
                                .dataType(document.getDataType())
                                .build(),
                        activityId,
                        "ACTIVITY")));
        }

        return activityId;
    }
}
