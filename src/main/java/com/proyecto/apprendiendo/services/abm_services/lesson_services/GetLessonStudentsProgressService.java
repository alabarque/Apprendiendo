package com.proyecto.apprendiendo.services.abm_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.StudentLessonDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetProjectStudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetLessonStudentsProgressService {

    private LessonRepository lessonRepository;
    private GetStudentLessonProgressService getStudentLessonProgressService;
    private GetProjectStudentsService getProjectStudentsService;

    public ArrayList<StudentLessonDTO> execute(Long lessonId) {

        Lesson lesson = lessonRepository.getById(lessonId);
        return getProjectStudentsService.execute(lesson.getProjectId()).stream().map(s -> getStudentLessonProgressService.execute(s.getId(),lessonId)).collect(Collectors.toCollection(ArrayList::new));
    }
}
