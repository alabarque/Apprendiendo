package com.proyecto.apprendiendo.services.general_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
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

    private StudentActivityRepository studentActivityRepository;
    private UserRepository userRepository;

    public ArrayList<UserDTO> execute(Long activityId) {
        ArrayList<StudentActivity> activityStudents = studentActivityRepository.findByActivityId(activityId);
        return activityStudents.stream()
                               .map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getStudentId())))
                               .collect(Collectors.toCollection(ArrayList::new));
    }
}
