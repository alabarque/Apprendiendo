package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;

    public Long execute(Long studentId, Long activityId, StudentProjectDTO studentProjectDTO){
        StudentProject studentProject = studentProjectRepository.findByUserIdAndProjectId(studentId, activityId);
        studentProject.setGrade(studentProjectDTO.getGrade());
        studentProject.setPercentageCompleted(studentProjectDTO.getPercentageCompleted());
        studentProjectRepository.save(studentProject);
        return studentProjectDTO.getId();
    }
}
