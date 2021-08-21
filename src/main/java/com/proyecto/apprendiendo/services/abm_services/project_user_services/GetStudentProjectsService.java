package com.proyecto.apprendiendo.services.abm_services.project_user_services;

import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.UserProjectRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentProjectsService {

    private ProjectRepository projectRepository;
    private UserProjectRepository userProjectRepository;
    private UserRepository userRepository;

    public ArrayList<ProjectDTO> execute(Long studentId) {
        ArrayList<UserProject> studentProjects = userProjectRepository.findByUserId(studentId);
        return studentProjects.stream().map(ps -> ProjectMapper.entityToDto(projectRepository.getById(ps.getProjectId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
