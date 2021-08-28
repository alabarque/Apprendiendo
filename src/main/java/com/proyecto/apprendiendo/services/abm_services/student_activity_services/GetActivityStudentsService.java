package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityStudentsService {

    private ActivityRepository activityRepository;
    private StudentActivityRepository studentActivityRepository;
    private UserRepository userRepository;

    public ArrayList<StudentDTO> execute(Long activityId) {
        ArrayList<StudentActivity> activityStudents = studentActivityRepository.findByActivityId(activityId);
        return activityStudents.stream().map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getUserId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
