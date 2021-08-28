package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChallengeDTO {
    private Long id;
    private String name;
    private Long conditionId; //FK a Condition
    private String text; //descripcion de existir.
    private Long targetId; //FK a Project o Activity: Donde esta disponible, tambien es el target de la condition.
    private String imageData; //imagen de existir, importante para los rewardType BADGE, CHALLENGE, ACHIEVEMENT
}
