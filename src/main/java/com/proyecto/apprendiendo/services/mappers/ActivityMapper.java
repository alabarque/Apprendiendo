package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;

public class ActivityMapper {
    public static ActivityDTO entityToDto(Activity activity) {
        return ActivityDTO.builder()
                          .id(activity.getId())
                          .position(activity.getPosition())
                          .name(activity.getName())
                          .description(activity.getDescription())
                          .lessonId(activity.getLessonId())
                          .startDate(activity.getStartDate())
                          .dueDate(activity.getDueDate())
                          .build();
    }

    public static ActivityTemplateDTO entityToTemplateDto(Activity activity) {
        return ActivityTemplateDTO.builder()
                                  .name(activity.getName())
                                  .description(activity.getDescription())
                                  .position(activity.getPosition())
                                  .startDate(activity.getStartDate())
                                  .dueDate(activity.getDueDate())
                                  .build();
    }

    public static ActivityDTO templateDtoToDto(ActivityTemplateDTO activityTemplateDTO) {
        return ActivityDTO.builder()
                          .name(activityTemplateDTO.getName())
                          .description(activityTemplateDTO.getDescription())
                          .position(activityTemplateDTO.getPosition())
                          .startDate(activityTemplateDTO.getStartDate())
                          .dueDate(activityTemplateDTO.getDueDate())
                          .build();
    }
}
