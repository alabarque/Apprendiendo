package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.UserProjectRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserService;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectStudentsService {

    private ProjectRepository projectRepository;
    private UserProjectRepository userProjectRepository;
    private UserRepository userRepository;

    public ArrayList<StudentDTO> execute(Long projectId) {
        ArrayList<UserProject> projectStudents = userProjectRepository.findByProjectId(projectId);
        return projectStudents.stream().map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getUserId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
