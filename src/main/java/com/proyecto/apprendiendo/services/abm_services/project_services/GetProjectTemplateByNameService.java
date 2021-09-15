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
public class GetProjectTemplateByNameService {

    private ProjectRepository projectRepository;

    public ProjectDTO execute(String templateName) {
        Project project = projectRepository.findByClassroomIdAndName(Long.parseLong("0"), templateName);
        return ProjectMapper.entityToDto(project);
    }
}
