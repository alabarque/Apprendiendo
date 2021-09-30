package com.proyecto.apprendiendo.services.abm_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityStudentsProgressService {

    private StudentActivityRepository studentActivityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;

    public ArrayList<StudentActivityDTO> execute(Long activityId) {
        ArrayList<StudentActivity> activityStudents = studentActivityRepository.findByActivityId(activityId);
        return activityStudents.stream().map(ps -> getStudentActivityProgressService.execute(ps.getUserId(),activityId)).collect(Collectors.toCollection(ArrayList::new));
    }
}
