package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentActivityProgressService {

    private StudentActivityRepository studentActivityRepository;

    public Long execute(Long studentId, Long activityId, StudentActivityDTO studentActivityDTO){
        StudentActivity studentActivity = studentActivityRepository.findByUserIdAndActivityId(studentId, activityId);
        studentActivity.setGrade(studentActivityDTO.getGrade());
        studentActivity.setPercentageCompleted(studentActivityDTO.getPercentageCompleted());
        studentActivity.setDateCompleted(studentActivityDTO.getDateCompleted());
        studentActivityRepository.save(studentActivity);
        return studentActivityDTO.getId();
    }
}
