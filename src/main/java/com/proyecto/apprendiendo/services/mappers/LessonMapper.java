package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;

public class LessonMapper {
    public static LessonDTO entityToDto(Lesson lesson) {
        return LessonDTO.builder()
                        .id(lesson.getId())
                        .name(lesson.getName())
                        .description(lesson.getDescription())
                        .position(lesson.getPosition())
                        .projectId(lesson.getProjectId())
                        .startDate(lesson.getStartDate())
                        .dueDate(lesson.getDueDate())
                        .active(lesson.getActive())
                        .build();
    }

    public static LessonTemplateDTO entityToTemplateDto(Lesson lesson) {
        return LessonTemplateDTO.builder()
                                .name(lesson.getName())
                                .description(lesson.getDescription())
                                .position(lesson.getPosition())
                                .startDate(lesson.getStartDate())
                                .dueDate(lesson.getDueDate())
                                .active(lesson.getActive())
                                .build();
    }

    public static LessonDTO templateDtoToDto(LessonTemplateDTO lessonTemplateDTO) {
        return LessonDTO.builder()
                        .name(lessonTemplateDTO.getName())
                        .description(lessonTemplateDTO.getDescription())
                        .position(lessonTemplateDTO.getPosition())
                        .startDate(lessonTemplateDTO.getStartDate())
                        .dueDate(lessonTemplateDTO.getDueDate())
                        .active(lessonTemplateDTO.getActive())
                        .build();
    }


}
