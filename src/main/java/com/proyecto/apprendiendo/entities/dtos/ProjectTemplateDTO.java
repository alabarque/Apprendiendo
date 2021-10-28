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
    private String description;
    private Long classroomId;
    private ClassroomDTO classroom;
    private Integer position;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private Boolean active;
    private ArrayList<LessonTemplateDTO> lessons;
    private ArrayList<RewardDTO> rewards;
    private ArrayList<DocumentDTO> documents;
}
