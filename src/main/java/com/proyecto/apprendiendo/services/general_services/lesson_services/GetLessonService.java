package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetLessonService {

    private LessonRepository lessonRepository;

    public LessonDTO execute(Long idClass) {
        Lesson lesson = lessonRepository.getById(idClass);
        return LessonMapper.entityToDto(lesson);
    }
}
