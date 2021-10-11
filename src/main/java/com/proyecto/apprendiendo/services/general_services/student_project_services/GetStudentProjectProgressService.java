package com.proyecto.apprendiendo.services.general_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private GetLessonService getLessonService;

    public StudentProjectDTO execute(Long studentId, Long projectId) {

        StudentProject studentProject = studentProjectRepository.findByUserIdAndProjectId(studentId, projectId);
        if (studentProject == null) studentProject = StudentProject.builder()
                                                                   .projectId(projectId)
                                                                   .userId(studentId)
                                                                   .percentageCompleted(0.00)
                                                                   .grade(0)
                                                                   .build();
        StudentProjectDTO studentProjectDTO = StudentProjectMapper.entityToDto(studentProject);

        if (studentProjectDTO.getPercentageCompleted() == 0.00) {

            Double percentageCompleted = activityRepository.findAll()
                                                           .stream()
                                                           .filter(a -> getLessonService.execute(a.getLessonId())
                                                                                        .getProjectId()
                                                                                        .equals(projectId))
                                                           .filter(a -> getLessonService.execute(a.getLessonId()).getActive())
                                                           .mapToDouble(a -> getStudentActivityProgressService.execute(studentId, a.getId())
                                                                                                              .getPercentageCompleted())
                                                           .average()
                                                           .getAsDouble();

            studentProjectDTO.setPercentageCompleted(percentageCompleted);
        }


        return studentProjectDTO;

    }
}
