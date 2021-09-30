package com.proyecto.apprendiendo.services.abm_services.condition_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateConditionService {

    private ConditionRepository conditionRepository;

    public Long execute(ConditionDTO conditionDTO) {
        Condition condition = Condition.builder()
                                       .conditionType(conditionDTO.getConditionType())
                                       .data(conditionDTO.getData())
                                       .text(conditionDTO.getText())
                                       .build();
        return conditionRepository.save(condition).getId();
    }
}
