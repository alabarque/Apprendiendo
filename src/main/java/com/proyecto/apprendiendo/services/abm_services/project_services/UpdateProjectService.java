package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateProjectService {

    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectDTO projectDTO){
        Project project = projectRepository.getById(projectDTO.getId());

        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setClassroomId(projectDTO.getClassroomId());
        project.setMethodologyId(projectDTO.getMethodologyId());
        project.setStartDate(projectDTO.getStartDate());
        project.setDueDate(projectDTO.getDueDate());
        project.setPosition(projectDTO.getPosition());

        projectRepository.save(project);
        return projectDTO.getId();
    }
}
