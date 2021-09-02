package com.proyecto.apprendiendo.services.abm_services.condition_services;

import com.proyecto.apprendiendo.entities.*;
import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.entities.enums.ConditionType;
import com.proyecto.apprendiendo.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.channels.CancelledKeyException;
import java.time.LocalDate;
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
            case TARGET_ACTIVITY_COMPLETED_X_DAYS_BEFORE_DUE_DATE: return  evaluateTargetActivityCompletedXDaysBeforeDueDate(studentId, reward);
            case TARGET_PROJECT_COMPLETED_X_DAYS_BEFORE_DUE_DATE: return  evaluateTargetProjectCompletedXDaysBeforeDueDate(studentId, reward);
            case TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X: return evaluateTargetCompletedWithScoreHigherThanX();
            case TARGET_COMPLETED_WITH_SCORE_HIGHEST_SCORE_IN_TARGET: return evaluateTargetCompletedWithScoreHighestInTarget();
            case TARGET_COMPLETED: return evaluateTargetCompleted();
            case X_PROJECTS_COMPLETED: return evaluateXProjectsCompleted();
            case X_ACTIVITIES_COMPLETED: return evaluateXActivitiesCompleted();
            case X_CLASSROOMS_COMPLETED: return evaluateXClassroomsCompleted();
        }

        return Boolean.TRUE;
    }

    private Boolean evaluateTargetActivityCompletedXDaysBeforeDueDate(Long studentId, Reward reward){
        StudentActivity studentActivity = studentActivityRepository.findByUserIdAndActivityId(studentId, reward.getTargetId());
        Activity activity = activityRepository.getById(reward.getTargetId());
        Condition condition = conditionRepository.getById(reward.getConditionId());
        if ((studentActivity.getPercentageCompleted() >= 100.00) &&
            (LocalDate.now().isBefore(activity.getDueDate().plusDays(Long.parseLong(condition.getData())))))
                    return Boolean.TRUE;
        else return Boolean.FALSE;

    }

    private Boolean evaluateTargetProjectCompletedXDaysBeforeDueDate(Long studentId, Reward reward){
        StudentProject studentProject = studentProjectRepository.findByUserIdAndProjectId(studentId, reward.getTargetId());
        Project project = projectRepository.getById(reward.getTargetId());
        Condition condition = conditionRepository.getById(reward.getConditionId());
        if ((studentProject.getPercentageCompleted() >= 100.00) &&
                    (LocalDate.now().isBefore(project.getDueDate().plusDays(Long.parseLong(condition.getData())))))
            return Boolean.TRUE;
        else return Boolean.FALSE;

    }

    private Boolean evaluateTargetCompletedWithScoreHigherThanX(){
        return Boolean.TRUE;
    }

    private Boolean evaluateTargetCompletedWithScoreHighestInTarget(){
        return Boolean.TRUE;
    }

    private Boolean evaluateTargetCompleted(){
        return Boolean.TRUE;
    }

    private Boolean evaluateXProjectsCompleted(){
        return Boolean.TRUE;
    }

    private Boolean evaluateXActivitiesCompleted(){
        return Boolean.TRUE;
    }

    private Boolean evaluateXClassroomsCompleted(){
        return Boolean.TRUE;
    }
}
