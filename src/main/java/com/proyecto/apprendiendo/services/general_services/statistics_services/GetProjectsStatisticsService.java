package com.proyecto.apprendiendo.services.general_services.statistics_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.StatisticDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityClassroomService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityLessonService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityProjectService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.Duration;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectsStatisticsService {
    private GetClassroomStudentsService getClassroomStudentsService;
    private GetClassroomService getClassroomService;
    private GetProjectService getProjectService;
    private ProjectRepository projectRepository;
    private GetStudentProjectProgressService getStudentProjectProgressService;

    public ArrayList<StatisticDTO> execute(Long targetId, String targetType) {
        return projectRepository.findAll()
                                .stream()
                                .filter(p -> targetFilter(p, targetId, targetType))
                                .flatMap(p -> getClassroomStudentsService.execute(p.getClassroomId())
                                                                         .stream()
                                                                         .map(s -> getStudentProjectProgressService.execute(s.getId(),p.getId()))
                                )
                                .collect(Collectors.groupingBy(sp -> sp.getProjectId(), Collectors.toCollection(ArrayList::new)))
                                .entrySet()
                                .stream()
                                .map( g -> {return StatisticDTO.builder()
                                                               .item(getProjectService.execute(g.getKey()))
                                                               .averageGrade(getAverageGrade(g.getValue()))
                                                               .averageCompletion(getAverageCompletion(g.getValue()))
                                                               .percentageCompleted(getPercentageCompleted(g.getValue()))
                                                               .averageDaysToDueDate(getAverageDaysToDueDate(g.getValue()))
                                                               .averageDaysToComplete(getAverageDaysToCompletion(g.getValue()))
                                                               .build();
                                })
                                .collect(Collectors.toCollection(ArrayList::new));

    }

    private Boolean targetFilter(Project project, Long targetId, String targetType){
        if (targetType.equals("CLASSROOM")) return project.getClassroomId().equals(targetId);
        if (targetType.equals("TEACHER")) if (!project.getClassroomId().equals(0L)) return getClassroomService.execute(project.getClassroomId()).getTeacherId().equals(targetId);
        return Boolean.FALSE;
    }

    private Double getPercentageCompleted(ArrayList<StudentProjectDTO> projectDTOs){
        Double completedProjects = (double) projectDTOs.stream().filter(sp -> sp.getPercentageCompleted().equals(100.00)).count();
        Double totalProjects = (double) projectDTOs.stream().count();

        if (totalProjects == 0) return null;
        else return (completedProjects/totalProjects) * 100;
    }

    private Double getAverageDaysToDueDate(ArrayList<StudentProjectDTO> projectDTOs){
        var duration = projectDTOs.stream()
                                                .filter(p-> p.getPercentageCompleted().equals(100.00))
                                                .filter(p -> p.getDateCompleted() != null)
                                                .filter(p -> getProjectService.execute(p.getProjectId()).getDueDate() != null)
                                                .map(p -> Duration.between(p.getDateCompleted(), getProjectService.execute(p.getProjectId()).getDueDate()))
                                                .mapToDouble(d -> d.toDays())
                                                .average();

        if (duration.isPresent()) return duration.getAsDouble();
        else return null;
    }

    private Double getAverageDaysToCompletion(ArrayList<StudentProjectDTO> projectDTOs){
        var duration = projectDTOs.stream()
                                                .filter(p-> p.getPercentageCompleted().equals(100.00))
                                                .filter(p -> p.getDateCompleted() != null)
                                                .filter(p -> getProjectService.execute(p.getProjectId()).getDueDate() != null)
                                                .map(p -> Duration.between(getProjectService.execute(p.getProjectId()).getStartDate(), p.getDateCompleted()))
                                                .mapToDouble(d -> d.toDays())
                                                .average();

        if (duration.isPresent()) return duration.getAsDouble();
        else return null;
    }

    private Double getAverageCompletion(ArrayList<StudentProjectDTO> projectDTOs){
        if(projectDTOs.size() == 0 ) return null;
        else return projectDTOs.stream().mapToDouble(StudentProjectDTO::getPercentageCompleted).average().getAsDouble();
    }

    private Double getAverageGrade(ArrayList<StudentProjectDTO> projectDTOs){
        if(projectDTOs.size() == 0 ) return null;

        OptionalDouble averageGrade = projectDTOs.stream().filter(sp -> sp.getGrade() != null).mapToDouble(StudentProjectDTO::getGrade).average();

        if (averageGrade.isPresent()) return averageGrade.getAsDouble();
        else return null;
    }


}
