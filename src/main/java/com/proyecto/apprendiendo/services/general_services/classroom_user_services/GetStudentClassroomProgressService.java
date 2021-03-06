package com.proyecto.apprendiendo.services.general_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
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
    private StudentProjectRepository studentProjectRepository;
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
                                                                   .mapToDouble(a -> {
                                                                       Long pid = getLessonService.execute(a.getLessonId()).getProjectId();
                                                                       StudentProject sp = studentProjectRepository.findByStudentIdAndProjectId(studentId, pid);
                                                                       if (sp != null) if (sp.getPercentageCompleted() != null) return sp.getPercentageCompleted();
                                                                       return getStudentActivityProgressService.execute(studentId, a.getId())
                                                                                                               .getPercentageCompleted();
                                                                   })
                                                                   .average();

            if (percentageCompleted.isPresent()) studentClassroomDTO.setPercentageCompleted(percentageCompleted.getAsDouble());
            else  studentClassroomDTO.setPercentageCompleted(0.00);
        }
        return studentClassroomDTO;
    }

    public StudentClassroomDTO execute(Long studentClassroomId){
        StudentClassroom studentClassroom = studentClassroomRepository.getById(studentClassroomId);
        return execute(studentClassroom.getStudentId(), studentClassroom.getClassroomId());
    }
}
