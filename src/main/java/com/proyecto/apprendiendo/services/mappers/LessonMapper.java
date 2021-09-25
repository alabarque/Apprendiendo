package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;

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

    public static LessonTemplateDTO entityToTemplateDto(Lesson lesson){
        return LessonTemplateDTO.builder()
                                .id(lesson.getId())
                                .name(lesson.getName())
                                .projectId(lesson.getProjectId())
                                .startDate(lesson.getStartDate())
                                .dueDate(lesson.getDueDate())
                                .build();
    }

    public static LessonDTO templateDtoToDto(LessonTemplateDTO lessonTemplateDTO){
        return LessonDTO.builder()
                        .id(lessonTemplateDTO.getId())
                        .name(lessonTemplateDTO.getName())
                        .projectId(lessonTemplateDTO.getProjectId())
                        .startDate(lessonTemplateDTO.getStartDate())
                        .dueDate(lessonTemplateDTO.getDueDate())
                        .build();
    }


}
