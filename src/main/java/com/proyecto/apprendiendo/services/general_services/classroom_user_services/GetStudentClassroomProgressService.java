package com.proyecto.apprendiendo.services.general_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.OptionalDouble;

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

        if (studentClassroomDTO.getPercentageCompleted() == null) {
            OptionalDouble percentageCompleted = activityRepository.findAll()
                                                                   .stream()
                                                                   .filter(a -> getProjectService.execute(getLessonService.execute(a.getLessonId()).getProjectId())
                                                                                                 .getClassroomId()
                                                                                                 .equals(classroomId))
                                                                   .filter(a -> getProjectService.execute(getLessonService.execute(a.getLessonId()).getProjectId()).getActive())
                                                                   .filter(a -> getLessonService.execute(a.getLessonId()).getActive())
                                                                   .mapToDouble(a -> getStudentActivityProgressService.execute(studentId, a.getId())
                                                                                                                      .getPercentageCompleted())
                                                                   .average();

            if (percentageCompleted.isPresent()) studentClassroomDTO.setPercentageCompleted(percentageCompleted.getAsDouble());
            else  studentClassroomDTO.setPercentageCompleted(0.00);
        }


        return studentClassroomDTO;
    }
}
