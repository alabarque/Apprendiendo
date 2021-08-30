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
public class CreateBadgeService {

    private RewardRepository rewardRepository;

    public Long execute(BadgeDTO badgeDTO) {
        Reward reward = Reward.builder().rewardType("BADGE").text(badgeDTO.getText()).conditionId(badgeDTO.getConditionId()).name(badgeDTO.getName()).text(badgeDTO.getText()).imageData(badgeDTO.getImageData()).build();
        return rewardRepository.save(reward).getId();
    }
}
