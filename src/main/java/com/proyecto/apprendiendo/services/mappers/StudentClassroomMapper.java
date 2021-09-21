package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;

public class StudentClassroomMapper {
    public static StudentClassroomDTO entityToDto(StudentClassroom studentClassroom){
        return StudentClassroomDTO.builder()
                              .id(studentClassroom.getId())
                              .classroomId(studentClassroom.getClassroomId())
                              .studentId(studentClassroom.getStudentId())
                              .grade(studentClassroom.getGrade())
                              .percentageCompleted(studentClassroom.getPercentageCompleted())
                              .dateCompleted(studentClassroom.getDateCompleted())
                              .build();
    }
}
