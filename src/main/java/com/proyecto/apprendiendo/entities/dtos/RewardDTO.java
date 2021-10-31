package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RewardDTO {
    private Long id;
    private String name;
    private Long conditionId;
    private ConditionDTO condition;
    private String text; //descripcion de existir.
    private String data;
    private String targetType; //ENUM TargetType
    private Long targetId;
    private Object target; //FK a Classroom, Project o Activity: Donde esta disponible, tambien es el target de la condition.
    private String imageData; //imagen de existir
    private String rewardType; //ENUM RewardType

}
