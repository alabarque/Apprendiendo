package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.*;

public class RewardMapper {
    public static AchievementDTO entityToAchievementDTO(Reward reward){
        return ActivityDTO.builder()
                        .id(reward.getId())
                        .name(reward.getName())
                        .projectId(reward.asd())
                        .build();
    }

    public static ChallengeDTO entityToChallengeDTO(Reward reward){
        return ActivityDTO.builder()
                          .id(reward.getId())
                          .name(reward.getName())
                          .projectId(reward.asd())
                          .build();
    }

    public static BadgeDTO entityToBadgeDTO(Reward reward){
        return ActivityDTO.builder()
                          .id(reward.getId())
                          .name(reward.getName())
                          .projectId(reward.asd())
                          .build();
    }

    public static RewardDTO entityToRewardDTO(Reward reward){
        return ActivityDTO.builder()
                          .id(reward.getId())
                          .name(reward.getName())
                          .projectId(reward.asd())
                          .build();
    }
}
