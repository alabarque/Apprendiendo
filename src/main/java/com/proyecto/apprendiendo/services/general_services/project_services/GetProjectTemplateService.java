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
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonTemplateService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetRewardAsTemplateService;
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
public class GetProjectTemplateService {

    private ProjectRepository projectRepository;
    private LessonRepository lessonRepository;
    private DocumentRepository documentRepository;
    private GetTargetRewardsService getTargetRewardsService;
    private GetLessonTemplateService getLessonTemplateService;
    private GetRewardAsTemplateService getRewardAsTemplateService;

    public ProjectTemplateDTO execute(Long projectId) {
        Project project = projectRepository.getById(projectId);
        ProjectTemplateDTO projectTemplateDTO = ProjectMapper.entityToTemplateDto(project);

        ArrayList<LessonTemplateDTO> lessons = lessonRepository.findByProjectId(project.getId())
                                                               .stream()
                                                               .map(lesson -> getLessonTemplateService.execute(lesson.getId()))
                                                               .collect(Collectors.toCollection(ArrayList::new));

        projectTemplateDTO.setLessons(lessons.stream()
                                             .sorted(Comparator.comparing(LessonTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                             .collect(Collectors.toCollection(ArrayList::new)));

        projectTemplateDTO.setDocuments(documentRepository.findBySourceId(projectId)
                                                        .stream()
                                                        .map(d -> DocumentMapper.entityToTemplateDto(d))
                                                        .sorted(Comparator.comparing(DocumentTemplateDTO::getPosition, Comparator.nullsFirst(Comparator.naturalOrder())))
                                                        .collect(Collectors.toCollection(ArrayList::new)));

        projectTemplateDTO.setRewards(getTargetRewardsService.execute(projectId)
                                                           .stream()
                                                           .map(reward -> getRewardAsTemplateService.execute(reward.getId()))
                                                           .collect(Collectors.toCollection(ArrayList::new)));

        return projectTemplateDTO;
    }
}
