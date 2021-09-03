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
    private Long userId; //FK a User
    private Long activityId; //FK a Activity
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
    private Integer grade;
}
