package com.proyecto.apprendiendo.services.general_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddClassroomStudentsService {

    private StudentClassroomRepository studentClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long classroomId, Long studentId) {
        if (studentClassroomRepository.findByStudentIdAndClassroomId(studentId,classroomId) == null) {
            studentClassroomRepository.save(StudentClassroom.builder()
                                                            .classroomId(classroomId)
                                                            .studentId(studentId)
                                                            .grade(0)
                                                            .percentageCompleted(0.00)
                                                            .build());
            }
        return classroomId;
    }
}
