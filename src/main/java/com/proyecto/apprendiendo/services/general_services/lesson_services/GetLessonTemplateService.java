package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
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
public class GetLessonTemplateService {

    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private DocumentRepository documentRepository;
    private GetTargetRewardsService getTargetRewardsService;
    private GetSourcesDocumentsService getSourcesDocumentsService;

    public LessonTemplateDTO execute(Long lessonId) {
        Lesson lesson = lessonRepository.getById(lessonId);
        LessonTemplateDTO lessonTemplate = LessonMapper.entityToTemplateDto(lesson);

        Map<Long, ActivityTemplateDTO> activities = activityRepository.findByLessonId(lessonId)
                                                                      .stream()
                                                                      .collect(Collectors.toMap(a -> a.getId(), a -> ActivityMapper.entityToTemplateDto(a)));

        activities.forEach((aid, a) -> a.setDocuments(documentRepository.findBySourceId(aid)
                                                                        .stream()
                                                                        .map(d -> DocumentMapper.entityToTemplateDto(d))
                                                                        .sorted(Comparator.comparing(DocumentTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                                                        .collect(Collectors.toCollection(ArrayList::new))));

        activities.forEach((aid, a) -> a.setRewards(getTargetRewardsService.execute(aid)));

        lessonTemplate.setActivities(activities.values()
                                               .stream()
                                               .sorted(Comparator.comparing(ActivityTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                               .collect(Collectors.toCollection(ArrayList::new)));

        lessonTemplate.setDocuments(getSourcesDocumentsService.execute(lessonId)
                                                              .stream()
                                                              .map(documentDTO -> DocumentMapper.dtoToTemplateDTO(documentDTO))
                                                              .collect(Collectors.toCollection(ArrayList::new)));

        return lessonTemplate;
    }
}
