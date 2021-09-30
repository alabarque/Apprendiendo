package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddActivityStudentsService {

    private StudentActivityRepository studentActivityRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long activityId, Long studentId) {
        studentActivityRepository.save(StudentActivity.builder()
                                                      .activityId(activityId)
                                                      .userId(studentId)
                                                      .percentageCompleted(0.00)
                                                      .grade(0)
                                                      .build());
        return activityId;
    }
}
