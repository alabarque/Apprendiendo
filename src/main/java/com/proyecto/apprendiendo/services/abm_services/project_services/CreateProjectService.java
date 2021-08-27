package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateProjectService {
    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(ProjectNewDTO projectNewDTO, Long classRoomId) {
        Project project = Project.builder()
                                 .methodologyId(projectNewDTO.getMethodologyId())
                                 .challengeId(projectNewDTO.getChallengeId())
                                 .classroomId(classRoomId)
                                 .name(projectNewDTO.getName())
                                 .startDate(projectNewDTO.getStartDate())
                                 .dueDate(projectNewDTO.getDueDate())
                                 .build();

        return projectRepository.save(project).getId();
    }
}
