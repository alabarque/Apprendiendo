package com.proyecto.apprendiendo.entities.dtos.ProjectDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private Long id;
    private Long methodologyId;
    private Long challengeId;
    private Long classroomId;
    private String name;
}
