package com.proyecto.apprendiendo.services.general_services.condition_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.entities.dtos.ConditionTemplateDTO;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import com.proyecto.apprendiendo.services.mappers.ConditionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateConditionFromTemplateService {

    private ConditionRepository conditionRepository;

    public Long execute(ConditionTemplateDTO conditionTemplateDTO) {
        Condition condition = conditionRepository.findByTextAndConditionTypeAndData(conditionTemplateDTO.getText(), conditionTemplateDTO.getConditionType(), conditionTemplateDTO.getData());

        if(condition != null) return condition.getId();

        condition = Condition.builder()
                             .conditionType(conditionTemplateDTO.getConditionType())
                             .data(conditionTemplateDTO.getData())
                             .text(conditionTemplateDTO.getText())
                             .build();
        return conditionRepository.save(condition).getId();
    }
}
