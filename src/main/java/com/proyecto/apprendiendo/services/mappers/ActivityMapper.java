package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;

public class ActivityMapper {
    public static ActivityDTO entityToDto(Activity activity){
        return ActivityDTO.builder()
                        .id(activity.getId())
                        .name(activity.getName())
                        .lessonId(activity.getLessonId())
                        .startDate(activity.getStartDate())
                        .dueDate(activity.getDueDate())
                        .build();
    }

    public static ActivityTemplateDTO entityToTemplateDto(Activity activity){
        return ActivityTemplateDTO.builder()
                                  .id(activity.getId())
                                  .name(activity.getName())
                                  .lessonId(activity.getLessonId())
                                  .startDate(activity.getStartDate())
                                  .dueDate(activity.getDueDate())
                                  .build();
    }

    public static ActivityDTO templateDtoToDto(ActivityTemplateDTO activityTemplateDTO){
        return ActivityDTO.builder()
                          .id(activityTemplateDTO.getId())
                          .name(activityTemplateDTO.getName())
                          .lessonId(activityTemplateDTO.getLessonId())
                          .startDate(activityTemplateDTO.getStartDate())
                          .dueDate(activityTemplateDTO.getDueDate())
                          .build();
    }
}
