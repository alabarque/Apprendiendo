package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProjectNewDTO {
    private Integer position;
    private Long methodologyId;
    private Long challengeId;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private Boolean active;
}
