package com.proyecto.apprendiendo.services.general_services.statistics_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.StatisticDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityClassroomService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityLessonService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityProjectService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
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
public class GetActivitiesStatisticsService {
    private GetActivityClassroomService getActivityClassroomService;
    private ActivityRepository activityRepository;
    private GetActivityService getActivityService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private GetActivityProjectService getActivityProjectService;
    private GetActivityLessonService getActivityLessonService;
    private com.proyecto.apprendiendo.services.general_services.user_services.GetStudentService getStudentService;
    private GetLessonService getLessonService;
    private GetClassroomService getClassroomService;
    private GetProjectService getProjectService;

    public ArrayList<StatisticDTO> execute(Long targetId, String targetType, String resultType) {
        return activityRepository.findAll()
                                 .stream()
                                 .filter(a -> targetFilter(a, targetId, targetType))
                                 .flatMap(a -> getClassroomStudentsService.execute(getActivityClassroomService.execute(a.getId()).getId())
                                                                          .stream()
                                                                          .map(s -> getStudentActivityProgressService.execute(s.getId(),a.getId()))
                                 )
                                 .collect(Collectors.groupingBy(sa -> getResultId(sa, resultType), Collectors.toCollection(ArrayList::new)))
                                 .entrySet()
                                 .stream()
                                 .map( g -> {return StatisticDTO.builder()
                                                                .item(getResultIdentity(g.getKey(), resultType))
                                                                .averageGrade(getAverageGrade(g.getValue()))
                                                                .averageCompletion(getAverageCompletion(g.getValue()))
                                                                .percentageCompleted(getPercentageCompleted(g.getValue()))
                                                                .averageDaysToDueDate(getAverageDaysToDueDate(g.getValue()))
                                                                .averageDaysToComplete(getAverageDaysToCompletion(g.getValue()))
                                                                .build();
                                 })
                                 .collect(Collectors.toCollection(ArrayList::new));
    }

    private Long getResultId(StudentActivityDTO studentActivity, String resultType){
        if (resultType.equals("ACTIVITY")) return studentActivity.getActivityId();
        if (resultType.equals("LESSON")) return getActivityLessonService.execute(studentActivity.getActivityId()).getId();
        if (resultType.equals("PROJECT")) return getActivityProjectService.execute(studentActivity.getActivityId()).getId();
        if (resultType.equals("CLASSROOM")) return getActivityClassroomService.execute(studentActivity.getActivityId()).getId();
        if (resultType.equals("STUDENT")) return getStudentService.execute(studentActivity.getUserId()).getId();
        else return null;
    }

    private Object getResultIdentity(Long childId, String resultType){
        if (resultType.equals("ACTIVITY")) return getActivityService.execute(childId);
        if (resultType.equals("LESSON")) return getLessonService.execute(childId);
        if (resultType.equals("PROJECT")) return getProjectService.execute(childId);
        if (resultType.equals("CLASSROOM")) return getClassroomService.execute(childId);
        if (resultType.equals("STUDENT")) return getStudentService.execute(childId);
        else return null;
    }

    private Boolean targetFilter(Activity activity, Long targetId, String targetType){
        if (targetType.equals("LESSON")) return activity.getLessonId().equals(targetId);
        if (targetType.equals("PROJECT")) return getActivityLessonService.execute(activity.getId()).getProjectId().equals(targetId);
        if (targetType.equals("CLASSROOM")) return getActivityProjectService.execute(activity.getId()).getClassroomId().equals(targetId);
        if (targetType.equals("TEACHER")) if (!getActivityClassroomService.execute(activity.getId()).equals(0L)) return getActivityClassroomService.execute(activity.getId()).getTeacherId().equals(targetId);
        return Boolean.FALSE;
    }

    private Double getPercentageCompleted(ArrayList<StudentActivityDTO> activities){
        Double completeActivities = (double) activities.stream().filter(sa -> sa.getPercentageCompleted().equals(100.00)).count();
        Double totalActivities = (double) activities.stream().count();

        if (totalActivities == 0) return null;
        else return (completeActivities/totalActivities) * 100;
    }

    private Double getAverageDaysToDueDate(ArrayList<StudentActivityDTO> activities){
        var duration = activities.stream()
                                               .filter(a-> a.getPercentageCompleted().equals(100.00))
                                               .filter(a -> a.getDateCompleted() != null)
                                               .filter(a -> getActivityService.execute(a.getActivityId()).getDueDate() != null)
                                               .map(a -> Duration.between(a.getDateCompleted(), getActivityService.execute(a.getActivityId()).getDueDate()))
                                                .mapToDouble(d -> d.toDays())
                                                .average();

        if (duration.isPresent()) return duration.getAsDouble();
        else return null;
    }

    private Double getAverageDaysToCompletion(ArrayList<StudentActivityDTO> activities){
        var duration = activities.stream()
                                               .filter(a-> a.getPercentageCompleted().equals(100.00))
                                               .filter(a -> a.getDateCompleted() != null)
                                               .filter(a -> getActivityService.execute(a.getActivityId()).getDueDate() != null)
                                               .map(a -> Duration.between(getActivityService.execute(a.getActivityId()).getStartDate(), a.getDateCompleted()))
                                                .mapToDouble(d -> d.toDays())
                                                .average();

        if (duration.isPresent()) return duration.getAsDouble();
        else return null;
    }

    private Double getAverageCompletion(ArrayList<StudentActivityDTO> activities){
        if(activities.size() == 0 ) return null;
        else return activities.stream().mapToDouble(StudentActivityDTO::getPercentageCompleted).average().getAsDouble();
    }

    private Double getAverageGrade(ArrayList<StudentActivityDTO> activities){
        if(activities.size() == 0 ) return null;
        else return activities.stream().mapToDouble(StudentActivityDTO::getGrade).average().getAsDouble();
    }


}
