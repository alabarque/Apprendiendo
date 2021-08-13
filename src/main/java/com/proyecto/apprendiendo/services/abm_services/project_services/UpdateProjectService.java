package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UpdateProjectService {

    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(ProjectDTO projectDTO){
        Project project = projectRepository.getById(projectDTO.getId());

        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setChallengeId(projectDTO.getChallengeId());
        project.setClassroomId(projectDTO.getClassroomId());
        project.setMethodologyId(projectDTO.getMethodologyId());

        projectRepository.save(project);
    }
}
