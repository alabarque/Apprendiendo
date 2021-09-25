package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectTemplateByMethodologyIdService {

    private ProjectRepository projectRepository;
    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private DocumentRepository documentRepository;
    private DocumentSourceRepository documentSourceRepository;

    public ProjectTemplateDTO execute(Long methodologyId) {
        Project project = projectRepository.findByClassroomIdAndMethodologyId(Long.parseLong("0"), methodologyId);
        ArrayList<LessonTemplateDTO> lessons = lessonRepository.findByProjectId(project.getId()).stream().map(l -> LessonMapper.entityToTemplateDto(l)).collect(Collectors.toCollection(ArrayList::new));
        lessons.forEach(l -> l.setActivities(activityRepository.findByLessonId(l.getId()).stream().map(a -> ActivityMapper.entityToTemplateDto(a)).collect(Collectors.toCollection(ArrayList::new))));
        lessons.forEach(l -> l.getActivities().forEach(a -> a.setDocuments(documentSourceRepository.findBySourceId(a.getId()).stream().map(sd -> DocumentMapper.entityToDto(documentRepository.getById(sd.getDocumentId()))).collect(Collectors.toCollection(ArrayList::new)))));

        ProjectTemplateDTO projectTemplateDTO = ProjectMapper.entityToTemplateDto(project);
        projectTemplateDTO.setLessons(lessons);

        return projectTemplateDTO;
    }
}
