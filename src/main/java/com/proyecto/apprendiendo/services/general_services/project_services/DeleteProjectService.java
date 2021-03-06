package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteProjectService {

    private ProjectRepository projectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long projectId) {
        projectRepository.deleteById(projectId);
        //TODO:hacer cascade
        return projectId;
    }
}
