package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityTemplateService;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetLessonTemplateService {

    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private DocumentRepository documentRepository;
    private GetActivityTemplateService getActivityTemplateService;

    public LessonTemplateDTO execute(Long lessonId) {
        Lesson lesson = lessonRepository.getById(lessonId);
        LessonTemplateDTO lessonTemplate = LessonMapper.entityToTemplateDto(lesson);

        ArrayList<ActivityTemplateDTO> activities = activityRepository.findByLessonId(lessonId)
                                                                      .stream()
                                                                      .map(activity -> getActivityTemplateService.execute(activity.getId()))
                                                                      .collect(Collectors.toCollection(ArrayList::new));

        lessonTemplate.setActivities(activities.stream()
                                               .sorted(Comparator.comparing(ActivityTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                               .collect(Collectors.toCollection(ArrayList::new)));

        lessonTemplate.setDocuments(documentRepository.findBySourceId(lessonId)
                                                        .stream()
                                                        .map(d -> DocumentMapper.entityToTemplateDto(d))
                                                        .sorted(Comparator.comparing(DocumentTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                                        .collect(Collectors.toCollection(ArrayList::new)));

        return lessonTemplate;
    }
}
