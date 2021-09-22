package com.proyecto.apprendiendo.services.abm_services.lesson_services;

import com.proyecto.apprendiendo.repositories.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteLessonService {

    private LessonRepository lessonRepository;

    public Long execute(Long lessonId){
        lessonRepository.deleteById(lessonId);
        return lessonId;
    }
}
