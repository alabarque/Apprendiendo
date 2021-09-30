package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentActivitiesService {

    private ActivityRepository activityRepository;
    private StudentActivityRepository studentActivityRepository;

    public ArrayList<ActivityDTO> execute(Long studentId) {
        ArrayList<StudentActivity> studentActivities = studentActivityRepository.findByUserId(studentId);
        return studentActivities.stream().map(ps -> ActivityMapper.entityToDto(activityRepository.getById(ps.getActivityId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
