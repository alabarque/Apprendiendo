package com.proyecto.apprendiendo.services.general_services.reward_services;

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
        Reward reward = Reward.builder()
                              .rewardType(rewardDTO.getRewardType())
                              .text(rewardDTO.getText())
                              .conditionId(rewardDTO.getConditionId())
                              .name(rewardDTO.getName())
                              .text(rewardDTO.getText())
                              .imageData(rewardDTO.getImageData())
                              .targetId(rewardDTO.getTargetId())
                              .targetType(rewardDTO.getTargetType())
                              .text(rewardDTO.getText())
                              .build();
        return rewardRepository.save(reward).getId();
    }
}
