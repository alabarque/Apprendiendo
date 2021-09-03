package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentClassroomProgressService {

    private StudentClassroomRepository studentClassroomRepository;

    public Long execute(Long studentId, Long activityId, StudentClassroomDTO studentClassroomDTO){
        StudentClassroom studentClassroom = studentClassroomRepository.findByStudentIdAndClassroomId(studentId, activityId);
        studentClassroom.setGrade(studentClassroomDTO.getGrade());
        studentClassroom.setPercentageCompleted(studentClassroomDTO.getPercentageCompleted());
        studentClassroom.setDateCompleted(studentClassroomDTO.getDateCompleted());
        studentClassroomRepository.save(studentClassroom);
        return studentClassroomDTO.getId();
    }
}
