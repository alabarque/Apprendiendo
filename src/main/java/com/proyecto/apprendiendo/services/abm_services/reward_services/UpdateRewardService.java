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
public class UpdateRewardService {

    private RewardRepository rewardRepository;

    public Long execute(RewardDTO rewardDTO){
        Reward reward = rewardRepository.getById(rewardDTO.getId());
        reward.setName(rewardDTO.getName());
        reward.setRewardType(rewardDTO.getRewardType());
        reward.setConditionId(rewardDTO.getConditionId());
        reward.setImageData(rewardDTO.getImageData());
        reward.setTargetId(rewardDTO.getTargetId());
        reward.setText(reward.getText());
        rewardRepository.save(reward);
        return rewardDTO.getId();
    }
}
