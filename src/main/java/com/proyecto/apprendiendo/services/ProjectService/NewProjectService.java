package com.proyecto.apprendiendo.services.ProjectService;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.NewProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewProjectService {
    private ProjectRepository projectRepository;

    public void execute(NewProjectDTO newProjectDTO, Long classRoomId) {
        Project project = Project.builder()
                                 .methodologyId(newProjectDTO.getMethodologyId())
                                 .challengeId(newProjectDTO.getChallengeId())
                                 .classroomId(classRoomId)
                                 .name(newProjectDTO.getName())
                                 .build();

        projectRepository.save(project);
    }
}
