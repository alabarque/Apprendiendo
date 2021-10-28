package com.proyecto.apprendiendo.services.general_services.student_activity_services;

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

    public StudentActivityDTO execute(Long studentId, Long activityId) {
        StudentActivity studentActivity = studentActivityRepository.findByStudentIdAndActivityId(studentId, activityId);

        if (studentActivity == null) studentActivity = StudentActivity.builder()
                                                                      .activityId(activityId)
                                                                      .studentId(studentId)
                                                                      .percentageCompleted(0.00)
                                                                      .build();

        if (studentActivity.getPercentageCompleted() == null) studentActivity.setPercentageCompleted(0.00);
        return StudentActivityMapper.entityToDto(studentActivity);
    }
}
