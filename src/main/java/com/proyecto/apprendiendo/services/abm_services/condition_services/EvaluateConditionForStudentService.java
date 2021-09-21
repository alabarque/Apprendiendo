package com.proyecto.apprendiendo.services.abm_services.condition_services;

import com.proyecto.apprendiendo.entities.*;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.entities.enums.ConditionType;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.annotation.Target;
import java.nio.channels.CancelledKeyException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

@Service
@AllArgsConstructor
@Transactional
public class EvaluateConditionForStudentService {

    private RewardRepository rewardRepository;
    private ConditionRepository conditionRepository;
    private ProjectRepository projectRepository;
    private ActivityRepository activityRepository;
    private ClassroomRepository classroomRepository;
    private StudentActivityRepository studentActivityRepository;
    private StudentProjectRepository studentProjectRepository;
    private StudentClassroomRepository studentClassroomRepository;

    public Boolean execute(Long rewardId, Long studentId) {
        Reward reward = rewardRepository.getById(rewardId);
        Condition condition = conditionRepository.getById(reward.getConditionId());

        switch (ConditionType.valueOf(condition.getConditionType())){
            case SOCIAL: return Boolean.FALSE;
            case TARGET_COMPLETED_X_DAYS_BEFORE_DUE_DATE: return  evaluateTargetProjectOrActivityCompletedXDaysBeforeDueDate(studentId, reward);
            case TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X: return evaluateTargetCompletedWithScoreHigherThanX(studentId, reward);
            case TARGET_COMPLETED_WITH_SCORE_HIGHEST_SCORE_IN_TARGET: return evaluateTargetCompletedWithScoreHighestInTarget(studentId, reward);
            case TARGET_COMPLETED: return evaluateTargetCompleted(studentId, reward);
            case X_PROJECTS_COMPLETED: return evaluateXProjectsCompleted(studentId, reward);
            case X_ACTIVITIES_COMPLETED: return evaluateXActivitiesCompleted(studentId, reward);
            case X_CLASSROOMS_COMPLETED: return evaluateXClassroomsCompleted(studentId, reward);
        }

        return Boolean.TRUE;
    }

    private Boolean evaluateTargetProjectOrActivityCompletedXDaysBeforeDueDate(Long studentId, Reward reward){
        LocalDateTime dueDate = getTargetDueDate(reward);
        LocalDateTime dateCompleted = getStudentDateCompletedFromTarget(studentId, reward);
        Integer daysBefore = Integer.valueOf(conditionRepository.getById(reward.getConditionId()).getData());

        if (evaluateTargetCompleted(studentId, reward) && (dateCompleted.isBefore(dueDate.plusDays(daysBefore)))) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateTargetCompletedWithScoreHigherThanX(Long studentId, Reward reward) {
        Integer targetScore = Integer.valueOf(conditionRepository.getById(reward.getConditionId()).getData());
        Integer studentScore = getStudentScoreFromTarget(studentId, reward);

        if (evaluateTargetCompleted(studentId, reward) && studentScore > targetScore) return Boolean.TRUE;
        else return Boolean.FALSE;
    }



    private Boolean evaluateTargetCompletedWithScoreHighestInTarget(Long studentId, Reward reward){
        Integer targetScore = getHighestScoreInTarget(reward);
        Integer studentScore = getStudentScoreFromTarget(studentId, reward);

        if (evaluateTargetCompleted(studentId, reward) && studentScore > targetScore) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXProjectsCompleted(Long studentId, Reward reward){
        long projectsCompleted = studentProjectRepository.findByUserIdAndPercentageCompleted(studentId, 100.00).stream().count();
        if( projectsCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData())) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXActivitiesCompleted(Long studentId, Reward reward){
        long activitiesCompleted = studentProjectRepository.findByUserIdAndPercentageCompleted(studentId, 100.00).stream().count();
        if( activitiesCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData())) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateXClassroomsCompleted(Long studentId, Reward reward){
        long classroomsCompleted = studentProjectRepository.findByUserIdAndPercentageCompleted(studentId, 100.00).stream().count();
        if( classroomsCompleted >= Long.parseLong(conditionRepository.getById(reward.getConditionId()).getData())) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    private Boolean evaluateTargetCompleted(Long studentId, Reward reward){
        if (getStudentCompletionFromTarget(studentId, reward) >= 100.00) return Boolean.TRUE;
        else  return Boolean.FALSE;
    }


    private Integer getStudentScoreFromTarget(Long studentId, Reward reward){
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString())) return studentProjectRepository.findByUserIdAndProjectId(studentId, reward.getTargetId()).getGrade();
        if (targetType.equals(TargetType.ACTIVITY.toString())) return studentActivityRepository.findByUserIdAndActivityId(studentId, reward.getTargetId()).getGrade();
        if (targetType.equals(TargetType.CLASSROOM.toString())) return studentClassroomRepository.findByStudentIdAndClassroomId(studentId, reward.getTargetId()).getGrade();
        return 0;
    }

    private LocalDateTime getStudentDateCompletedFromTarget(Long studentId, Reward reward){
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString())) return studentProjectRepository.findByUserIdAndProjectId(studentId, reward.getTargetId()).getDateCompleted();
        if (targetType.equals(TargetType.ACTIVITY.toString())) return studentActivityRepository.findByUserIdAndActivityId(studentId, reward.getTargetId()).getDateCompleted();
        if (targetType.equals(TargetType.CLASSROOM.toString())) return studentClassroomRepository.findByStudentIdAndClassroomId(studentId, reward.getTargetId()).getDateCompleted();
        return LocalDateTime.now().plusYears(99);
    }

    private Double getStudentCompletionFromTarget(Long studentId, Reward reward){
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString())) return studentProjectRepository.findByUserIdAndProjectId(studentId, reward.getTargetId()).getPercentageCompleted();
        if (targetType.equals(TargetType.ACTIVITY.toString())) return studentActivityRepository.findByUserIdAndActivityId(studentId, reward.getTargetId()).getPercentageCompleted();
        if (targetType.equals(TargetType.CLASSROOM.toString())) return studentClassroomRepository.findByStudentIdAndClassroomId(studentId, reward.getTargetId()).getPercentageCompleted();
        return 0.00;
    }

    private LocalDateTime getTargetDueDate(Reward reward){
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString())) return projectRepository.getById(reward.getTargetId()).getDueDate();
        if (targetType.equals(TargetType.ACTIVITY.toString())) return activityRepository.getById(reward.getTargetId()).getDueDate();
        return LocalDateTime.now();
    }
    private Integer getHighestScoreInTarget(Reward reward){
        String targetType = reward.getTargetType();
        if (targetType.equals(TargetType.PROJECT.toString())) return studentProjectRepository.findByProjectId(reward.getTargetId()).stream().map(st -> st.getGrade()).max(Integer::compare).get();
        if (targetType.equals(TargetType.ACTIVITY.toString())) return studentActivityRepository.findByActivityId(reward.getTargetId()).stream().map(st -> st.getGrade()).max(Integer::compare).get();
        if (targetType.equals(TargetType.CLASSROOM.toString())) return studentClassroomRepository.findByClassroomId(reward.getTargetId()).stream().map(st -> st.getGrade()).max(Integer::compare).get();
        return 0;
    }

}
