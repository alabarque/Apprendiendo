package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class CreateProjectService {
    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectDTO projectDTO) {
        Project project = Project.builder()
                                 .methodologyId(projectDTO.getMethodologyId())
                                 .classroomId(projectDTO.getClassroomId())
                                 .name(projectDTO.getName())
                                 .description(projectDTO.getDescription())
                                 .startDate(projectDTO.getStartDate())
                                 .dueDate(projectDTO.getDueDate())
                                 .position(projectDTO.getPosition())
                                 .active(projectDTO.getActive())
                                 .build();

        if (projectDTO.getStartDate() == null) project.setStartDate(LocalDateTime.now());

        return projectRepository.save(project).getId();
    }
}
