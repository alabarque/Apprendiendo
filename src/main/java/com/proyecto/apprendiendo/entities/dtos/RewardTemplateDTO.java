package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RewardTemplateDTO {
    private String name;
    private ConditionTemplateDTO condition;
    private String text; //descripcion de existir.
    private String data;
    private String targetType; //ENUM TargetType
    private String imageData; //imagen de existir
    private String rewardType; //ENUM RewardType

}
