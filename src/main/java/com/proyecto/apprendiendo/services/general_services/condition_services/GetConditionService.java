package com.proyecto.apprendiendo.services.general_services.condition_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import com.proyecto.apprendiendo.services.mappers.ConditionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetConditionService {

    private ConditionRepository conditionRepository;

    public ConditionDTO execute(Long idClass) {
        Condition condition = conditionRepository.getById(idClass);
        return ConditionMapper.entityToDto(condition);
    }
}
