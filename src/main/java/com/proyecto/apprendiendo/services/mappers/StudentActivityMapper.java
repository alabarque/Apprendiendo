package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;

public class StudentActivityMapper {
    public static StudentActivityDTO entityToDto(StudentActivity studentActivity){
        return StudentActivityDTO.builder()
                              .id(studentActivity.getId())
                              .activityId(studentActivity.getActivityId())
                              .userId(studentActivity.getUserId())
                              .grade(studentActivity.getGrade())
                              .challengeCompleted(studentActivity.getChallengeCompleted())
                              .percentageCompleted(studentActivity.getPercentageCompleted())
                              .build();
    }
}
