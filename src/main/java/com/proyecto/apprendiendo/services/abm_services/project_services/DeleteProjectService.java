package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProjectService {

    private ProjectRepository projectRepository;

    public void execute(Long projectId){
        projectRepository.deleteById(projectId);
    }
}
