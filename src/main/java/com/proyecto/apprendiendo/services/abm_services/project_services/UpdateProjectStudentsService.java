package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UpdateProjectStudentsService {

    private UserProjectRepository userProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long projectId, ArrayList<StudentDTO> studentDTOs){
        userProjectRepository.deleteByProjectId(projectId);
        studentDTOs.forEach(s -> userProjectRepository.save(UserProject.builder().projectId(projectId).userId(s.getId()).build()));
    }
}
