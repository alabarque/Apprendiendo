package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectLessonsService {

    private LessonRepository lessonRepository;

    public ArrayList<LessonDTO> execute(Long projectId) {
        ArrayList<Lesson> lessons = lessonRepository.findByProjectId(projectId);
        return lessons.stream().map(lesson -> LessonMapper.entityToDto(lesson)).collect(Collectors.toCollection(ArrayList::new));
    }
}
