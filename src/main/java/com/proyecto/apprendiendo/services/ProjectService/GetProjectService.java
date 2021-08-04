package com.proyecto.apprendiendo.services.ProjectService;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProjectService {

    private ProjectRepository projectRepository;

    public ProjectDTO execute(Long projectId) {
        Project project = projectRepository.getById(projectId);
        return ProjectMapper.entityToDto(project);
    }
}
