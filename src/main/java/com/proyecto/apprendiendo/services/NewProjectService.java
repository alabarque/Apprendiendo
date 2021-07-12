package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.NewProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class NewProjectService {
    private ProjectRepository projectRepository;

    public void execute(NewProjectDTO newProjectDTO) {
        Project project = Project.builder()
                                 .methodologyId(newProjectDTO.getMethodologyId())
                                 .challengeId(newProjectDTO.getChallengeId())
                                 .classroomId(newProjectDTO.getClassroomId())
                                 .name(newProjectDTO.getName())
                                 .build();

        projectRepository.save(project);
    }
}
