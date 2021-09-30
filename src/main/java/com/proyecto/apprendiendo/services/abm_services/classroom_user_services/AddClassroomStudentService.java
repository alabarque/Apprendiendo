package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddClassroomStudentService {

    private StudentClassroomRepository studentClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long classroomId, Long studentId) {
        studentClassroomRepository.save(StudentClassroom.builder()
                                                        .classroomId(classroomId)
                                                        .studentId(studentId)
                                                        .grade(0)
                                                        .percentageCompleted(0.00)
                                                        .build());
        return classroomId;
    }
}
