package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;

public class ActivityMapper {
    public static ActivityDTO entityToDto(Activity activity){
        return ActivityDTO.builder()
                        .id(activity.getId())
                        .name(activity.getName())
                        .projectId(activity.getProjectId())
                        .previousActivityId(activity.getPreviousActivityId())
                        .challengeId(activity.getChallengeId())
                        .build();

    }
}
