package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetLessonClassroomService {

    private LessonRepository lessonRepository;
    private GetProjectClassroomService getProjectClassroomService;

    public ClassroomDTO execute(Long lessonId) {
        Lesson lesson = lessonRepository.getById(lessonId);

        return getProjectClassroomService.execute(lesson.getProjectId());
    }
}
