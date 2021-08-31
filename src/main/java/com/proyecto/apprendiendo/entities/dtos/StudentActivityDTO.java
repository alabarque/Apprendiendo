package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentActivityDTO {
    private Long id;
    private Long userId; //FK a User
    private Long activityId; //FK a Activity
    private Double percentageCompleted;
    private Integer grade;
}
