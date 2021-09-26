package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class StudentLessonDTO {
    private Long id;
    private Long studentId; //FK a User
    private Long projectId; //FK a Activity
    private Double percentageCompleted;
}
