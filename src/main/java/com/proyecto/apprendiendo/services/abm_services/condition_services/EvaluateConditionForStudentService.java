package com.proyecto.apprendiendo.services.abm_services.condition_services;

import com.proyecto.apprendiendo.entities.Condition;
import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.enums.ConditionType;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomProjectsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsProgressService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetStudentClassroomsService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.GetActivityStudentsProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetProjectStudentsProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class EvaluateConditionForStudentService {

    private RewardRepository rewardRepository;
    private ConditionRepository conditionRepository;
    private ProjectRepository projectRepository;
    private ActivityRepository activityRepository;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private GetStudentProjectProgressService getStudentProjectProgressService;
    private GetStudentClassroomProgressService getStudentClassroomProgressService;
    private GetClassroomStudentsProgressService getClassroomStudentsProgressService;
    private GetProjectStudentsProgressService getProjectStudentsProgressService;
    private GetActivityStudentsProgressService getActivityStudentsProgressService;
    private GetStudentClassroomsService getStudentClassroomsService;
    private GetClassroomProjectsService getClassroomProjectsService;
    private StudentActivityRepository studentActivityRepository;

    public Boolean execute(Long rewardId, Long studentId) {
        Reward reward = rewardRepository.getById(rewardId);
        Condition condition = conditionRepository.getById(reward.getConditionId());

        switch (ConditionType.valueOf(condition.getConditionType())) {
            case SOCIAL:
                return Boolean.FALSE;
            case TARGET_COMPLETED_X_DAYS_BEFORE_DUE_DATE:
                return evaluateTargetProjectOrActivityCompletedXDaysBeforeDueDate(studentId, reward);
            case TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X:
                return evaluateTargetCompletedWithScoreHigherThanX(studentId, reward);
            case TARGET_COMPLETED_WITH_SCORE_HIGHEST_SCORE_IN_TARGET:
                return evaluateTargetCompletedWithScoreHighestInTarget(studentId, reward);
            case TARGET_COMPLETED:
                return evaluateTargetCompleted(studentId, reward);
            case X_PROJECTS_COMPLETED:
                return evaluateXProjectsCompleted(studentId, reward);
            case X_ACTIVITIES_COMPLETED:
                return evaluateXActivitiesCompleted(studentId, reward);
            case X_CLASSROOMS_COMPLETED:
                return evaluateXClassroomsCompleted(studentId, reward);
        }

        return Boolean.TRUE;
    }

    private Boolean evaluateTargetProjectOrActivityCompletedXDaysBeforeDueDate(Long studentId, Reward reward) {
        LocalDateTime dueDate = getTargetDueDate(reward);
        LocalDateTime dateCompleted = getStudentDateCompletedFromTarget(studentId, reward);
        Integer daysBefore = Integer.valueOf(conditionRepository.getById(reward.getConditionId()).getData());

        if (evaluateTargetCompleted(studentId, reward) && (dateCompleted.isBefore(dueDate.plusDays(daysBefore))))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateTargetCompletedWithScoreHigherThanX(Long studentId, Reward reward) {
        Integer targetScore = Integer.valueOf(conditionRepository.getById(reward.getConditionId()).getData());
        Integer studentScore = getStudentScoreFromTarget(studentId, reward);

        if (evaluateTargetCompleted(studentId, reward) && studentScore > targetScore) return Boolean.TRUE;
        else return Boolean.FALSE;
    }


    private Boolean evaluateTargetCompletedWithScoreHighestInTarget(Long studentId, Reward reward) {
        Integer targetScore = getHighestScoreInTarget(reward);
        Integer studentScore = getStudentScoreFromTarget(studentId, reward);

        if (evaluateTargetCompleted(studentId, reward) && studentScore > targetScore) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXProjectsCompleted(Long studentId, Reward reward) {
        Long projectsCompleted = getStudentClassroomsService.execute(studentId)
                                                            .stream()
                                                            .flatMap( classroom -> getClassroomProjectsService.execute(classroom.getId()).stream())
                                                            .filter(p -> getStudentProjectProgressService.execute(studentId,p.getId()).getPercentageCompleted() >= 100.00)
                                                            .count();

        if (projectsCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData()))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXActivitiesCompleted(Long studentId, Reward reward) {
        long activitiesCompleted = studentActivityRepository.findByUserIdAndPercentageCompleted(studentId, 100.00)
                                                            .stream()
                                                            .count();

        if (activitiesCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData()))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXClassroomsCompleted(Long studentId, Reward reward) {
        long classroomsCompleted = getStudentClassroomsService.execute(studentId)
                                                            .stream()
                                                            .filter(p -> getStudentClassroomProgressService.execute(studentId,p.getId()).getPercentageCompleted() >= 100.00)
                                                            .count();

        if (classroomsCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData()))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateTargetCompleted(Long studentId, Reward reward) {
        if (getStudentCompletionFromTarget(studentId, reward) >= 100.00) return Boolean.TRUE;
        else return Boolean.FALSE;
    }


    private Integer getStudentScoreFromTarget(Long studentId, Reward reward) {
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString()))
            return getStudentProjectProgressService.execute(studentId, reward.getTargetId()).getGrade();
        if (targetType.equals(TargetType.ACTIVITY.toString()))
            return getStudentActivityProgressService.execute(studentId, reward.getTargetId()).getGrade();
        if (targetType.equals(TargetType.CLASSROOM.toString()))
            return getStudentClassroomProgressService.execute(studentId, reward.getTargetId()).getGrade();
        return 0;
    }

    private LocalDateTime getStudentDateCompletedFromTarget(Long studentId, Reward reward) {
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString()))
            return getStudentProjectProgressService.execute(studentId, reward.getTargetId())
                                                   .getDateCompleted();
        if (targetType.equals(TargetType.ACTIVITY.toString()))
            return getStudentActivityProgressService.execute(studentId, reward.getTargetId())
                                                    .getDateCompleted();
        if (targetType.equals(TargetType.CLASSROOM.toString()))
            return getStudentClassroomProgressService.execute(studentId, reward.getTargetId())
                                                     .getDateCompleted();
        return LocalDateTime.now().plusYears(99);
    }

    private Double getStudentCompletionFromTarget(Long studentId, Reward reward) {
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString()))
            return getStudentProjectProgressService.execute(studentId, reward.getTargetId())
                                           .getPercentageCompleted();
        if (targetType.equals(TargetType.ACTIVITY.toString()))
            return getStudentActivityProgressService.execute(studentId, reward.getTargetId())
                                            .getPercentageCompleted();
        if (targetType.equals(TargetType.CLASSROOM.toString()))
            return getStudentClassroomProgressService.execute(studentId, reward.getTargetId())
                                             .getPercentageCompleted();
        return 0.00;
    }

    private LocalDateTime getTargetDueDate(Reward reward) {
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString()))
            return projectRepository.getById(reward.getTargetId()).getDueDate();
        if (targetType.equals(TargetType.ACTIVITY.toString()))
            return activityRepository.getById(reward.getTargetId()).getDueDate();
        return LocalDateTime.now();
    }

    private Integer getHighestScoreInTarget(Reward reward) {
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString()))
            return getProjectStudentsProgressService.execute(reward.getTargetId())
                                           .stream()
                                           .map(st -> st.getGrade())
                                           .max(Integer::compare)
                                           .get();
        if (targetType.equals(TargetType.ACTIVITY.toString()))
            return getActivityStudentsProgressService.execute(reward.getTargetId())
                                            .stream()
                                            .map(st -> st.getGrade())
                                            .max(Integer::compare)
                                            .get();
        if (targetType.equals(TargetType.CLASSROOM.toString()))
            return getClassroomStudentsProgressService.execute(reward.getTargetId())
                                             .stream()
                                             .map(st -> st.getGrade())
                                             .max(Integer::compare)
                                             .get();
        return 0;
    }

}
