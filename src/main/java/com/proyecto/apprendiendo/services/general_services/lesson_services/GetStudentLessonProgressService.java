package com.proyecto.apprendiendo.services.general_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.StudentLessonDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.OptionalDouble;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentLessonProgressService {

    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;

    public StudentLessonDTO execute(Long studentId, Long lessonId) {
        Lesson lesson = lessonRepository.getById(lessonId);
        StudentLessonDTO studentLessonDTO = StudentLessonDTO.builder()
                                                            .studentId(studentId)
                                                            .projectId(lesson.getProjectId())
                                                            .id(lessonId)
                                                            .build();

        OptionalDouble percentageCompleted = activityRepository.findAll()
                                                               .stream()
                                                               .filter(a -> a.getLessonId().equals(lessonId))
                                                               .mapToDouble(a -> getStudentActivityProgressService.execute(studentId, a.getId())
                                                                                                                  .getPercentageCompleted())
                                                               .average();

        if (percentageCompleted.isPresent()) studentLessonDTO.setPercentageCompleted(percentageCompleted.getAsDouble());
        else  studentLessonDTO.setPercentageCompleted(0.00);

        return studentLessonDTO;
    }
}
