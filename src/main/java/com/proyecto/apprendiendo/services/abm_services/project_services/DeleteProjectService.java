package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DeleteProjectService {

    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long projectId){
        projectRepository.deleteById(projectId);
    }
}
