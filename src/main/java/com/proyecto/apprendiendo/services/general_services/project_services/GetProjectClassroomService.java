package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectClassroomService {

    private ProjectRepository projectRepository;
    private GetClassroomService getClassroomService;

    public ClassroomDTO execute(Long projectId) {
        Project project = projectRepository.getById(projectId);
        if(project.getClassroomId() == 0) return null;
        return getClassroomService.execute(project.getClassroomId());
    }
}
