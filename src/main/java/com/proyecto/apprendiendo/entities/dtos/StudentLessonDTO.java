package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentLessonDTO {
    private Long id;
    private Long studentId; //FK a User
    private Long projectId; //FK a Activity
    private Double percentageCompleted;
}
