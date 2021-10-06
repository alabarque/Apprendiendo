package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveProjectStudentsService {

    private StudentProjectRepository studentProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long projectId, Long studentId) {
        studentProjectRepository.deleteByProjectIdAndUserId(projectId, studentId);
        return projectId;
    }
}
