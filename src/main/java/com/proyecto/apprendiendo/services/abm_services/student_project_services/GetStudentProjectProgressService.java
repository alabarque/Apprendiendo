package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
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
public class GetStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;
    private StudentActivityRepository studentActivityRepository;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private LessonRepository lessonRepository;

    public StudentProjectDTO execute(Long studentId, Long projectId){
        StudentProjectDTO studentProjectDTO = StudentProjectMapper.entityToDto(studentProjectRepository.findByUserIdAndProjectId(studentId, projectId));

        if(studentProjectDTO.getPercentageCompleted() == 0.00) {
            Double percentageCompleted = studentActivityRepository.findByUserId(studentId)
                                                                  .stream()
                                                                  .filter(sa -> lessonRepository.getById(activityRepository.getById(sa.getActivityId()).getLessonId()).getProjectId().equals(projectId))
                                                                  .mapToDouble(sp -> getStudentActivityProgressService.execute(sp.getUserId(), sp.getActivityId()).getPercentageCompleted())
                                                                  .average()
                                                                  .getAsDouble();

            studentProjectDTO.setPercentageCompleted(percentageCompleted);
        }


        return studentProjectDTO;

    }
}
