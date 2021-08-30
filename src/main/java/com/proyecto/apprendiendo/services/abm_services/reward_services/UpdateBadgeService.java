package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.BadgeDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateBadgeService {

    private RewardRepository rewardRepository;

    public Long execute(BadgeDTO badgeDTO){
        Reward reward = rewardRepository.getById(badgeDTO.getId());
        reward.setId(badgeDTO.getId());
        reward.setName(badgeDTO.getName());
        reward.setRewardType("BADGE");
        reward.setConditionId(badgeDTO.getConditionId());
        reward.setImageData(badgeDTO.getImageData());
        reward.setText(reward.getText());
        rewardRepository.save(reward);
        return badgeDTO.getId();
    }
}
