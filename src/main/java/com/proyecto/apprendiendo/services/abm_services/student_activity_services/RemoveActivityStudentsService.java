package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveActivityStudentsService {

    private StudentActivityRepository studentActivityRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long activityId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> studentActivityRepository.deleteByActivityIdAndUserId(activityId,s.getId()));
        return activityId;
    }
}