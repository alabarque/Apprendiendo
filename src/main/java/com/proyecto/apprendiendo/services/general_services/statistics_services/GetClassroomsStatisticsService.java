package com.proyecto.apprendiendo.services.general_services.statistics_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.StatisticDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class GetClassroomsStatisticsService {
    private GetClassroomStudentsService getClassroomStudentsService;
    private GetClassroomService getClassroomService;
    private ClassroomRepository classroomRepository;
    private GetStudentClassroomProgressService getStudentClassroomProgressService;

    public ArrayList<StatisticDTO> execute(Long teacherId) {
        return classroomRepository.findByTeacherId(teacherId)
                                .stream()
                                .flatMap(c -> getClassroomStudentsService.execute(c.getId())
                                                                         .stream()
                                                                         .map(s -> getStudentClassroomProgressService.execute(s.getId(),c.getId()))
                                )
                                .collect(Collectors.groupingBy(sp -> sp.getClassroomId(), Collectors.toCollection(ArrayList::new)))
                                .entrySet()
                                .stream()
                                .map( g -> {return StatisticDTO.builder()
                                                               .item(getClassroomService.execute(g.getKey()))
                                                               .averageGrade(getAverageGrade(g.getValue()))
                                                               .averageCompletion(getAverageCompletion(g.getValue()))
                                                               .percentageCompleted(getPercentageCompleted(g.getValue()))
                                                               .build();
                                })
                                .collect(Collectors.toCollection(ArrayList::new));

    }

    private Double getPercentageCompleted(ArrayList<StudentClassroomDTO> classroomDTOs){
        Double completedProjects = (double) classroomDTOs.stream().filter(sp -> sp.getPercentageCompleted().equals(100.00)).count();
        Double totalProjects = (double) classroomDTOs.stream().count();

        if (totalProjects == 0) return null;
        else return (completedProjects/totalProjects) * 100;
    }

    private Double getAverageCompletion(ArrayList<StudentClassroomDTO> classroomDTOs){
        if(classroomDTOs.size() == 0 ) return null;
        else return classroomDTOs.stream().mapToDouble(StudentClassroomDTO::getPercentageCompleted).average().getAsDouble();
    }

    private Double getAverageGrade(ArrayList<StudentClassroomDTO> classroomDTOs){
        if(classroomDTOs.size() == 0 ) return null;
        else return classroomDTOs.stream().mapToDouble(StudentClassroomDTO::getGrade).average().getAsDouble();
    }


}
