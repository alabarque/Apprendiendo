package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;

public class LessonMapper {
    public static LessonDTO entityToDto(Lesson lesson){
        return LessonDTO.builder()
                        .id(lesson.getId())
                        .name(lesson.getName())
                        .projectId(lesson.getProjectId())
                        .startDate(lesson.getStartDate())
                        .dueDate(lesson.getDueDate())
                        .build();
    }
}
