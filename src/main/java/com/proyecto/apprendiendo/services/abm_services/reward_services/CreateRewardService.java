package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateRewardService {

    private RewardRepository rewardRepository;

    public Long execute(RewardDTO rewardDTO) {
        Reward reward = Reward.builder().rewardType("SOCIAL").text(rewardDTO.getText()).conditionId(rewardDTO.getConditionId()).name(rewardDTO.getName()).text(rewardDTO.getText()).imageData(rewardDTO.getImageData()).targetId(rewardDTO.getTargetId()).build();
        return rewardRepository.save(reward).getId();
    }
}
