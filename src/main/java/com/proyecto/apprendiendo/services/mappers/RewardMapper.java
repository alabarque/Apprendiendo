package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;

public class RewardMapper {

    public static RewardDTO entityToDTO(Reward reward) {
        return RewardDTO.builder()
                        .id(reward.getId())
                        .name(reward.getName())
                        .conditionId(reward.getConditionId())
                        .imageData(reward.getImageData())
                        .targetId(reward.getTargetId())
                        .text(reward.getText())
                        .rewardType(reward.getRewardType())
                        .targetType(reward.getTargetType())
                        .build();
    }
}
