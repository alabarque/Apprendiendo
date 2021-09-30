package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.services.abm_services.reward_services.AutomaticRewardGrantingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentClassroomProgressService {

    AddClassroomStudentService addClassroomStudentService;
    private StudentClassroomRepository studentClassroomRepository;
    private AutomaticRewardGrantingService automaticRewardGrantingService;

    public Long execute(Long studentId, Long classroomId, StudentClassroomDTO studentClassroomDTO) {
        StudentClassroom studentClassroom = studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId);
        if (studentClassroom == null) {
            addClassroomStudentService.execute(classroomId, studentId);
            studentClassroom = studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId);
        }
        studentClassroom.setGrade(studentClassroomDTO.getGrade());
        studentClassroom.setPercentageCompleted(studentClassroomDTO.getPercentageCompleted());
        studentClassroom.setDateCompleted(studentClassroomDTO.getDateCompleted());
        studentClassroomRepository.save(studentClassroom);
        automaticRewardGrantingService.execute(studentId, classroomId, "CLASSROOM");
        return studentClassroomDTO.getId();
    }
}
