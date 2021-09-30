package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;

public class ConditionMapper {
    public static ConditionDTO entityToDto(Condition condition){
        return ConditionDTO.builder()
                           .id(condition.getId())
                           .conditionType(condition.getConditionType())
                           .data(condition.getData())
                           .text(condition.getText())
                           .build();
    }
}
