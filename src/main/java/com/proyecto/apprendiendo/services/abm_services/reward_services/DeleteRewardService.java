package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.repositories.ConditionRepository;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteRewardService {

    private RewardRepository rewardRepository;
    private ConditionRepository conditionRepository;

    public Long execute(Long rewardId) {
        Reward reward = rewardRepository.getById(rewardId);
        if (reward.getConditionId() != 0) conditionRepository.deleteById(reward.getConditionId());
        rewardRepository.deleteById(rewardId);
        return rewardId;
    }
}
