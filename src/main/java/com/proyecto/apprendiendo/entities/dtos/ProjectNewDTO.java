package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectNewDTO {
    private Long methodologyId;
    private Long challengeId;
    private String name;
}
