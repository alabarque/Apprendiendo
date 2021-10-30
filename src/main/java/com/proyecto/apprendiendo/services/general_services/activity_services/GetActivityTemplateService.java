package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityTemplateService {

    private ActivityRepository activityRepository;
    private DocumentRepository documentRepository;
    private GetTargetRewardsService getTargetRewardsService;

    public ActivityTemplateDTO execute(Long activityId) {
        Activity activity = activityRepository.getById(activityId);
        ActivityTemplateDTO activityTemplate = ActivityMapper.entityToTemplateDto(activity);

        activityTemplate.setDocuments(documentRepository.findBySourceId(activityId)
                                                        .stream()
                                                        .map(d -> DocumentMapper.entityToTemplateDto(d))
                                                        .sorted(Comparator.comparing(DocumentTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                                        .collect(Collectors.toCollection(ArrayList::new)));

        activityTemplate.setRewards(getTargetRewardsService.execute(activityId));

        return activityTemplate;
    }
}
