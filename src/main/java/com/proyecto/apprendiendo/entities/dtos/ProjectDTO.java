package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private Long id;
    private Integer position;
    private Long methodologyId;
    private Long classroomId;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
}
