package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentLessonDTO {
    private Long id;
    private Long studentId;
    private StudentDTO student;
    private Long lessonId;
    private LessonDTO lesson;
    private Double percentageCompleted;
}
