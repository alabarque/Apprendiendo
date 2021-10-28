package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class LessonDTO {
    private Long id;
    private Integer position;
    private String name;
    private String description;
    private Long projectId;
    private ProjectDTO project;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private Boolean active;
}
