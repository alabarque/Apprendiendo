package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class StudentActivityDTO {
    private Long id;
    private Long studentId;
    private StudentDTO student; //FK a User
    private Long activityId;
    private ActivityDTO activity; //FK a Activity
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
    private Integer grade;
}
