package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;

public class StudentProjectMapper {
    public static StudentProjectDTO entityToDto(StudentProject studentProject) {
        return StudentProjectDTO.builder()
                                .id(studentProject.getId())
                                .projectId(studentProject.getProjectId())
                                .studentId(studentProject.getStudentId())
                                .grade(studentProject.getGrade())
                                .percentageCompleted(studentProject.getPercentageCompleted())
                                .dateCompleted(studentProject.getDateCompleted())
                                .build();
    }
}
