package com.proyecto.apprendiendo.services.general_services.student_project_services;

import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RemoveProjectStudentsService {

    private StudentProjectRepository studentProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long projectId, Long studentId) {
        studentProjectRepository.deleteByProjectIdAndStudentId(projectId, studentId);
        return projectId;
    }
}
