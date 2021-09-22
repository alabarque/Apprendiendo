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
    private String name;
    private Long projectId;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
}
