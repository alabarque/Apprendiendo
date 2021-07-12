package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewProjectDTO {
    private Long methodologyId;
    private Long challengeId;
    private Long classroomId;
    private String name;
}
