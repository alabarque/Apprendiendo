package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AchievementDTO {
    private Long id;
    private String name;
    private Long conditionId; //FK a Condition
    private String text; //descripcion de existir.
    private Long targetId; //FK a Classroom
    private String imageData;
}
