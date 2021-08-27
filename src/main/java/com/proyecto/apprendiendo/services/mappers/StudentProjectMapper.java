package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;

public class StudentProjectMapper {
    public static StudentProjectDTO entityToDto(StudentProject studentProject){
        return StudentProjectDTO.builder()
                              .id(studentProject.getId())
                              .projectId(studentProject.getProjectId())
                              .userId(studentProject.getUserId())
                              .grade(studentProject.getGrade())
                              .challengeCompleted(studentProject.getChallengeCompleted())
                              .percentageCompleted(studentProject.getPercentageCompleted())
                              .build();
    }
}
