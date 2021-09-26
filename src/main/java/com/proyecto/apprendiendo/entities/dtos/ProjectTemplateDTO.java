package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Builder
public class ProjectTemplateDTO {
    private String name;
    private Integer position;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private ArrayList<LessonTemplateDTO> lessons;
}
