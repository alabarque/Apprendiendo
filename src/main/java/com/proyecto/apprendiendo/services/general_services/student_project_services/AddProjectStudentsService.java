package com.proyecto.apprendiendo.services.general_services.student_project_services;

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
    public Long execute(Long projectId, Long studentId) {
        if (studentProjectRepository.findByUserIdAndProjectId(studentId,projectId) == null){
            studentProjectRepository.save(StudentProject.builder()
                                                        .projectId(projectId)
                                                        .userId(studentId)
                                                        .build());
        }
        return projectId;
    }
}
