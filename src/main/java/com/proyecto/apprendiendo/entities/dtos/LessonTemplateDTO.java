package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.Activity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Builder
public class LessonTemplateDTO {
    private Long id;
    private String name;
    private Long projectId;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private ArrayList<ActivityTemplateDTO> activities;
}
