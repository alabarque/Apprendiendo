package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
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
public class GetProjectStudentsProgressService {
    
    private StudentProjectRepository studentProjectRepository;
    private GetStudentProjectProgressService getStudentProjectProgressService;

    public ArrayList<StudentProjectDTO> execute(Long projectId) {
        ArrayList<StudentProject> projectStudents = studentProjectRepository.findByProjectId(projectId);
        return projectStudents.stream().map(ps -> getStudentProjectProgressService.execute(ps.getUserId(),projectId)).collect(Collectors.toCollection(ArrayList::new));
    }
}
