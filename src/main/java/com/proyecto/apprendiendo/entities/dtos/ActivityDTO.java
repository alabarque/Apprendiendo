package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ActivityDTO {
    private Long id;
    private Integer position;
    private String name;
    private Long lessonId;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
}
