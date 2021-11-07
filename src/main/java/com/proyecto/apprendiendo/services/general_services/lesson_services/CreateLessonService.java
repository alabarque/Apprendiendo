package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class CreateLessonService {

    private LessonRepository lessonRepository;

    public Long execute(LessonDTO lessonDTO) {
        Lesson lesson = Lesson.builder()
                              .name(lessonDTO.getName())
                              .description(lessonDTO.getDescription())
                              .position(lessonDTO.getPosition())
                              .projectId(lessonDTO.getProjectId())
                              .startDate(lessonDTO.getStartDate())
                              .dueDate(lessonDTO.getDueDate())
                              .active(lessonDTO.getActive())
                              .build();
        if (lessonDTO.getStartDate() == null) lesson.setStartDate(LocalDateTime.now());

        return lessonRepository.save(lesson).getId();
    }
}
