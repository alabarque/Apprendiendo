package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ActivityDTO {
    private Long id;
    private String name;
    private String description;
    private Long challengeId;
    private Long projectId;
    private Long previousActivityId;
}
