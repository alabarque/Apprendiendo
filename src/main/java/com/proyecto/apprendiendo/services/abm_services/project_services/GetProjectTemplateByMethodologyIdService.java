package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectTemplateByMethodologyIdService {

    private ProjectRepository projectRepository;

    public ProjectDTO execute(Long methodologyId) {
        Project project = projectRepository.findByClassroomIdAndMethodologyId(Long.parseLong("0"), methodologyId);
        return ProjectMapper.entityToDto(project);
    }
}
