package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.ConditionTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardTemplateDTO;

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
                        .data(reward.getData())
                        .build();
    }

    public static RewardTemplateDTO entityToTemplateDTO(Reward reward, ConditionTemplateDTO condition) {
        return RewardTemplateDTO.builder()
                                .name(reward.getName())
                                .imageData(reward.getImageData())
                                .text(reward.getText())
                                .rewardType(reward.getRewardType())
                                .targetType(reward.getTargetType())
                                .data(reward.getData())
                                .condition(condition)
                                .build();
    }


}
