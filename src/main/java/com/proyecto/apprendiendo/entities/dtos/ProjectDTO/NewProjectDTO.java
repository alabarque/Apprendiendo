package com.proyecto.apprendiendo.entities.dtos.ProjectDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewProjectDTO {
    private Long methodologyId;
    private Long challengeId;
    private String name;
}
