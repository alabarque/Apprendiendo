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
public class UpdateLessonService {

    private LessonRepository lessonRepository;

    public Long execute(LessonDTO lessonDTO) {
        Lesson lesson = lessonRepository.getById(lessonDTO.getId());
        lesson.setId(lessonDTO.getId());
        lesson.setName(lessonDTO.getName());
        lesson.setProjectId(lessonDTO.getProjectId());
        lesson.setDueDate(lessonDTO.getDueDate());
        lesson.setStartDate(lessonDTO.getStartDate());
        lesson.setPosition(lessonDTO.getPosition());
        lesson.setActive(lessonDTO.getActive());
        lessonRepository.save(lesson);
        return lessonDTO.getId();
    }
}
