package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private Long id;
    private Integer position;
    private Long methodologyId;
    private MethodologyDTO methodology;
    private Long classroomId;
    private ClassroomDTO classroom;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private Boolean active;
}
