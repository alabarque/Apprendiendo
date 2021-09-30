package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.abm_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomProjectsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.GetLessonActivitiesService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectLessonsService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentClassroomProgressService {

    private StudentClassroomRepository studentClassroomRepository;
    private GetProjectService getProjectService;
    private GetLessonService getLessonService;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;

    public StudentClassroomDTO execute(Long studentId, Long classroomId){
        StudentClassroomDTO studentClassroomDTO = StudentClassroomMapper.entityToDto(studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId));

        if(studentClassroomDTO.getPercentageCompleted() == 0.00) {
            Double percentageCompleted = activityRepository.findAll()
                                                           .stream()
                                                           .filter(a -> getProjectService.execute(getLessonService.execute(a.getLessonId()).getProjectId()).getClassroomId().equals(classroomId))
                                                           .mapToDouble(a -> getStudentActivityProgressService.execute(studentId, a.getId()).getPercentageCompleted())
                                                           .average()
                                                           .getAsDouble();

            studentClassroomDTO.setPercentageCompleted(percentageCompleted);
        }


        return studentClassroomDTO;
    }
}
