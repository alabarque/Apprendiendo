package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
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
public class GetProjectTemplateService {

    private ProjectRepository projectRepository;
    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private DocumentRepository documentRepository;

    public ProjectTemplateDTO execute(Long projectId) {
        Project project = projectRepository.getById(projectId);
        Map<Long, LessonTemplateDTO> lessons = lessonRepository.findByProjectId(project.getId())
                                                               .stream()
                                                               .collect(Collectors.toMap(l -> l.getId(), l -> LessonMapper.entityToTemplateDto(l)));

        lessons.forEach((lid, l) -> {
            Map<Long, ActivityTemplateDTO> activities = activityRepository.findByLessonId(lid)
                                                                          .stream()
                                                                          .collect(Collectors.toMap(a -> a.getId(), a -> ActivityMapper.entityToTemplateDto(a)));
            activities.forEach((aid, a) -> a.setDocuments(documentRepository.findBySourceId(aid)
                                                                            .stream()
                                                                            .map(d -> DocumentMapper.entityToTemplateDto(d))
                                                                            .sorted(Comparator.comparing(DocumentTemplateDTO::getPosition))
                                                                            .collect(Collectors.toCollection(ArrayList::new))));
            l.setActivities(activities.values()
                                      .stream()
                                      .sorted(Comparator.comparing(ActivityTemplateDTO::getPosition))
                                      .collect(Collectors.toCollection(ArrayList::new)));
        });

        ProjectTemplateDTO projectTemplateDTO = ProjectMapper.entityToTemplateDto(project);
        projectTemplateDTO.setLessons(lessons.values()
                                             .stream()
                                             .sorted(Comparator.comparing(LessonTemplateDTO::getPosition))
                                             .collect(Collectors.toCollection(ArrayList::new)));

        return projectTemplateDTO;
    }
}
