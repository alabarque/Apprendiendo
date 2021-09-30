package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.services.mappers.StudentActivityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentActivityProgressService {

    private StudentActivityRepository studentActivityRepository;

    public StudentActivityDTO execute(Long studentId, Long activityId){
        StudentActivity studentActivity = studentActivityRepository.findByUserIdAndActivityId(studentId, activityId);

        if(studentActivity == null) studentActivity = StudentActivity.builder().activityId(activityId).userId(studentId).percentageCompleted(0.00).grade(0).build();
        return StudentActivityMapper.entityToDto(studentActivity);
    }
}
