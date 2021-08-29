package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.*;

public class RewardMapper {
    public static AchievementDTO entityToAchievementDTO(Reward reward){
        return AchievementDTO.builder()
                             .id(reward.getId())
                             .name(reward.getName())
                             .conditionId(reward.getConditionId())
                             .imageData(reward.getImageData())
                             .targetId(reward.getTargetId())
                             .text(reward.getText())
                             .build();
    }

    public static ChallengeDTO entityToChallengeDTO(Reward reward){
        return ChallengeDTO.builder()
                           .id(reward.getId())
                           .name(reward.getName())
                           .conditionId(reward.getConditionId())
                           .imageData(reward.getImageData())
                           .targetId(reward.getTargetId())
                           .text(reward.getText())
                           .build();
    }

    public static BadgeDTO entityToBadgeDTO(Reward reward){
        return BadgeDTO.builder()
                       .id(reward.getId())
                       .name(reward.getName())
                       .conditionId(reward.getConditionId())
                       .imageData(reward.getImageData())
                       .text(reward.getText())
                       .build();
    }

    public static RewardDTO entityToRewardDTO(Reward reward){
        return RewardDTO.builder()
                        .id(reward.getId())
                        .name(reward.getName())
                        .conditionId(reward.getConditionId())
                        .imageData(reward.getImageData())
                        .targetId(reward.getTargetId())
                        .text(reward.getText())
                        .build();
    }
}
