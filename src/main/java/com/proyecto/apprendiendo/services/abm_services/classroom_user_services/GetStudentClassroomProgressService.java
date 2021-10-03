package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentClassroomProgressService {

    private StudentClassroomRepository studentClassroomRepository;
    private GetProjectService getProjectService;
    private GetLessonService getLessonService;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;

    public StudentClassroomDTO execute(Long studentId, Long classroomId) {
        StudentClassroomDTO studentClassroomDTO = StudentClassroomMapper.entityToDto(studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId));

        if (studentClassroomDTO.getPercentageCompleted() == 0.00) {
            Double percentageCompleted = activityRepository.findAll()
                                                           .stream()
                                                           .filter(a -> getProjectService.execute(getLessonService.execute(a.getLessonId()).getProjectId())
                                                                                         .getClassroomId()
                                                                                         .equals(classroomId))
                                                           .filter(a -> getProjectService.execute(getLessonService.execute(a.getLessonId()).getProjectId()).getActive())
                                                           .filter(a -> getLessonService.execute(a.getLessonId()).getActive())
                                                           .mapToDouble(a -> getStudentActivityProgressService.execute(studentId, a.getId())
                                                                                                              .getPercentageCompleted())
                                                           .average()
                                                           .getAsDouble();

            studentClassroomDTO.setPercentageCompleted(percentageCompleted);
        }


        return studentClassroomDTO;
    }
}
