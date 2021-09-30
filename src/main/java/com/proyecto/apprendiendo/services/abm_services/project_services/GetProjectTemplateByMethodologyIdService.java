package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectTemplateByMethodologyIdService {

    private ProjectRepository projectRepository;
    private GetProjectTemplateService getProjectTemplateService;

    public ProjectTemplateDTO execute(Long methodologyId) {
        return getProjectTemplateService.execute(projectRepository.findByClassroomIdAndMethodologyId(Long.parseLong("0"), methodologyId)
                                                                  .getId());
    }
}
