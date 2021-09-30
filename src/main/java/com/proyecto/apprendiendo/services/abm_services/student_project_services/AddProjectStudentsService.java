package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddProjectStudentsService {

    private StudentProjectRepository studentProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long projectId, Long studentId){
        studentProjectRepository.save(StudentProject.builder().projectId(projectId).userId(studentId).percentageCompleted(0.00).grade(0).build());
        return projectId;
    }
}
