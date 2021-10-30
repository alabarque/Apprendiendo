package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class StudentProjectDTO {
    private Long id;
    private Long studentId;
    private UserDTO student; //FK a User
    private Long projectId;
    private ProjectDTO project; //FK a Project
    private Double percentageCompleted; //Valor entre 0 y 1
    private LocalDateTime dateCompleted;
    private Integer grade;
}
