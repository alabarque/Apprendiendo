package com.proyecto.apprendiendo.services.general_services.reward_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.ConditionTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardTemplateDTO;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.services.mappers.ConditionMapper;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetRewardAsTemplateService {

    private RewardRepository rewardRepository;
    private ConditionRepository conditionRepository;

    public RewardTemplateDTO execute(Long rewardId) {
        Reward reward = rewardRepository.getById(rewardId);

        ConditionTemplateDTO conditionTemplate = ConditionMapper.entityToTemplateDto(conditionRepository.getById(reward.getConditionId()));

        return RewardMapper.entityToTemplateDTO(reward, conditionTemplate);
    }
}
