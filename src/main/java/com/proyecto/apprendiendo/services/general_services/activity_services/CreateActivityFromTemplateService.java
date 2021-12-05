package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.general_services.condition_services.CreateConditionFromTemplateService;
import com.proyecto.apprendiendo.services.general_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.CreateLessonService;
import com.proyecto.apprendiendo.services.general_services.reward_services.CreateRewardFromTemplateService;
import com.proyecto.apprendiendo.services.general_services.reward_services.CreateRewardService;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateActivityFromTemplateService {
    private CreateActivityService createActivityService;
    private CreateDocumentService createDocumentService;
    private CreateRewardFromTemplateService createRewardFromTemplateService;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(ActivityTemplateDTO activityTemplateDTO, Long lessonId) {
        ActivityDTO activityDTO = ActivityMapper.templateDtoToDto(activityTemplateDTO);
        activityDTO.setLessonId(lessonId);
        Long activityId = createActivityService.execute(activityDTO);

        if (activityTemplateDTO.getDocuments() != null) {
            activityTemplateDTO.getDocuments().forEach(document -> {
                createDocumentService.execute(DocumentMapper.templateDtoToDto(document, activityId, "ACTIVITY"));
            });
        }

        if (activityTemplateDTO.getRewards() != null) {
            activityTemplateDTO.getRewards().forEach(reward -> {
                createRewardFromTemplateService.execute(reward, activityId, "ACTIVITY");
            });
        }
        return activityId;
    }
}
