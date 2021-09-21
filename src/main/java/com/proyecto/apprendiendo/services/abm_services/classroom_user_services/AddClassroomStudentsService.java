package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddClassroomStudentsService {

    private StudentClassroomRepository studentClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long classroomId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> studentClassroomRepository.save(StudentClassroom.builder().classroomId(classroomId).studentId(s.getId()).grade(0).percentageCompleted(0.00).build()));
        return classroomId;
    }
}
