package com.proyecto.apprendiendo.services.abm_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateLessonService {

    private LessonRepository lessonRepository;

    public Long execute(LessonDTO lessonDTO) {
        Lesson lesson = Lesson.builder().name(lessonDTO.getName()).position(lessonDTO.getPosition()).projectId(lessonDTO.getProjectId()).startDate(lessonDTO.getStartDate()).dueDate(lessonDTO.getDueDate()).build();
        return lessonRepository.save(lesson).getId();
    }
}
