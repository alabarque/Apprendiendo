package com.proyecto.apprendiendo.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Project {
    private Long id;
    private Long methodologyId;
    private Long retoId;
    private Long classroomId;
    private String name;
}
