package com.proyecto.apprendiendo.services.ProjectService;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProjectService {

    private ProjectRepository projectRepository;

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
