package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentProjectDTO {
    private Long id;
    private Long userId; //FK a User
    private Long projectId; //FK a Project
    private Double percentageCompleted; //Valor entre 0 y 1
    private Integer grade;
}
