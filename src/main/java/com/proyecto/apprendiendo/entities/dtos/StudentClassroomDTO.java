package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class StudentClassroomDTO {
    private Long id;
    private Long studentId; //FK a User
    private Long classroomId; //FK a Classroom
    private Integer grade;
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
}
