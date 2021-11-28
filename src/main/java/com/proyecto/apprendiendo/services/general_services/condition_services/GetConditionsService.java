package com.proyecto.apprendiendo.services.general_services.condition_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import com.proyecto.apprendiendo.services.mappers.ConditionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetConditionsService {

    private ConditionRepository conditionRepository;

    public ArrayList<ConditionDTO> execute() {
        return conditionRepository.findAll().stream().map(c -> ConditionMapper.entityToDto(c)).collect(Collectors.toCollection(ArrayList::new));
    }
}
