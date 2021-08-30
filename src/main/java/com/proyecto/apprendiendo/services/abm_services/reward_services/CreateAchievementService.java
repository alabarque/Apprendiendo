package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.AchievementDTO;
import com.proyecto.apprendiendo.entities.dtos.ChallengeDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateAchievementService {

    private RewardRepository rewardRepository;

    public Long execute(AchievementDTO achievementDTO) {
        Reward reward = Reward.builder().rewardType("ACHIEVEMENT").text(achievementDTO.getText()).conditionId(achievementDTO.getConditionId()).name(achievementDTO.getName()).text(achievementDTO.getText()).imageData(achievementDTO.getImageData()).targetId(achievementDTO.getTargetId()).build();
        return rewardRepository.save(reward).getId();
    }
}
