package com.proyecto.apprendiendo.services.abm_services.lesson_services;

import com.proyecto.apprendiendo.entities.Lesson;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentLessonDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.LessonRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentActivityMapper;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentLessonProgressService {

    private StudentActivityRepository studentActivityRepository;
    private LessonRepository lessonRepository;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;

    public StudentLessonDTO execute(Long studentId, Long lessonId){
        Lesson lesson = lessonRepository.getById(lessonId);
        StudentLessonDTO studentLessonDTO = StudentLessonDTO.builder().studentId(studentId).projectId(lesson.getProjectId()).id(lessonId).build();

        Double percentageCompleted = studentActivityRepository.findByUserId(studentId)
                                                              .stream()
                                                              .filter(sa -> activityRepository.getById(sa.getActivityId()).getLessonId().equals(lessonId))
                                                              .mapToDouble(sp -> getStudentActivityProgressService.execute(sp.getUserId(), sp.getActivityId()).getPercentageCompleted())
                                                              .average()
                                                              .getAsDouble();

        studentLessonDTO.setPercentageCompleted(percentageCompleted);

        return studentLessonDTO;
    }
}