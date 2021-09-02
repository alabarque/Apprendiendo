package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private Long id;
    private Long methodologyId;
    private Long challengeId;
    private Long classroomId;
    private String name;
    private LocalDate startDate;
    private LocalDate dueDate;
}
