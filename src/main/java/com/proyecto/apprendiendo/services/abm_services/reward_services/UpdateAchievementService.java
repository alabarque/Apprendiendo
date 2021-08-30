package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.AchievementDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateAchievementService {

    private RewardRepository rewardRepository;

    public Long execute(AchievementDTO achievementDTO){
        Reward reward = rewardRepository.getById(achievementDTO.getId());
        reward.setId(achievementDTO.getId());
        reward.setName(achievementDTO.getName());
        reward.setRewardType("ACHIEVEMENT");
        reward.setConditionId(achievementDTO.getConditionId());
        reward.setImageData(achievementDTO.getImageData());
        reward.setTargetId(achievementDTO.getTargetId());
        reward.setText(reward.getText());
        rewardRepository.save(reward);
        return achievementDTO.getId();
    }
}
