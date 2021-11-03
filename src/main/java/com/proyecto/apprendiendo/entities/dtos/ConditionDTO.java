package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConditionDTO {
    private Long id;
    private String text; //descripcion, importante que exista para conditionType SOCIAL
    private String conditionType; //Enum ConditionType
    private String data; //Se usa junto al ConditionType para evaluar la Condition
}
