package com.proyecto.apprendiendo.services.general_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectStudentsService {

    private StudentProjectRepository studentProjectRepository;
    private UserRepository userRepository;

    public ArrayList<UserDTO> execute(Long projectId) {
        ArrayList<StudentProject> projectStudents = studentProjectRepository.findByProjectId(projectId);
        return projectStudents.stream()
                              .map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getStudentId())))
                              .collect(Collectors.toCollection(ArrayList::new));
    }
}
