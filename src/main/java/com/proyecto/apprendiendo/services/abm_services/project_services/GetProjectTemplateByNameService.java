package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectTemplateByNameService {

    private ProjectRepository projectRepository;
    private GetProjectTemplateService getProjectTemplateService;

    public ProjectTemplateDTO execute(String templateName) {
        return getProjectTemplateService.execute(projectRepository.findByClassroomIdAndName(Long.parseLong("0"), templateName).getId());
    }
}
