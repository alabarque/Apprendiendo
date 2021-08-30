package com.proyecto.apprendiendo.services.abm_services.condition_services;

import com.proyecto.apprendiendo.repositories.ConditionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteConditionService {

    private ConditionRepository conditionRepository;

    public Long execute(Long conditionId){
        conditionRepository.deleteById(conditionId);
        return conditionId;
    }
}
