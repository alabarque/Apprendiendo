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
    private Long studentId;
    private UserDTO student; //FK a User
    private Long classroomId;
    private ClassroomDTO classroom; //FK a Classroom
    private Integer grade;
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
}
