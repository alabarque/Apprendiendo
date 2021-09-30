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
public class UpdateConditionService {

    private ConditionRepository conditionRepository;

    public Long execute(ConditionDTO conditionDTO) {
        Condition condition = conditionRepository.getById(conditionDTO.getId());
        condition.setConditionType(conditionDTO.getConditionType());
        condition.setData(conditionDTO.getData());
        condition.setText(conditionDTO.getText());
        conditionRepository.save(condition);
        return conditionDTO.getId();
    }
}
