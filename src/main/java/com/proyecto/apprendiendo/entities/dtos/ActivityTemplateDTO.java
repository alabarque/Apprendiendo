package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.Document;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Builder
public class ActivityTemplateDTO {
    private Long id;
    private String name;
    private Long lessonId;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private ArrayList<DocumentDTO> documents;
}
