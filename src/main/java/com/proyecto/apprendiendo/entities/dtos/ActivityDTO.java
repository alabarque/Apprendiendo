package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
public class ActivityDTO {
    private Long id;
    private String name;
    private Long projectId;
    private LocalDate dueDate;
    private LocalDate startDate;
}
