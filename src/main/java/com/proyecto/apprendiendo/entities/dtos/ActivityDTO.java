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
    private Long ownerId; //FK a User, Project
    private Long projectId;
}
