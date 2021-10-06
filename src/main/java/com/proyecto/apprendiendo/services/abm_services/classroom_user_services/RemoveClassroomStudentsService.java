package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveClassroomStudentsService {

    private StudentClassroomRepository studentClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long classroomId, Long studentId) {
        studentClassroomRepository.deleteByClassroomIdAndStudentId(classroomId, studentId);
        return classroomId;
    }
}
