package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Builder
public class LessonTemplateDTO {
    private String name;
    private String description;
    private Integer position;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private Boolean active;
    private ArrayList<ActivityTemplateDTO> activities;
}
