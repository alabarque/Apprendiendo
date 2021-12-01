package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.entities.dtos.ConditionTemplateDTO;

public class ConditionMapper {
    public static ConditionDTO entityToDto(Condition condition) {
        return ConditionDTO.builder()
                           .id(condition.getId())
                           .conditionType(condition.getConditionType())
                           .data(condition.getData())
                           .text(condition.getText())
                           .build();
    }

    public static ConditionTemplateDTO entityToTemplateDto(Condition condition) {
        return ConditionTemplateDTO.builder()
                                   .conditionType(condition.getConditionType())
                                   .data(condition.getData())
                                   .text(condition.getText())
                                   .build();
    }
}
