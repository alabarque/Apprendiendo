package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.condition_services.EvaluateConditionForStudentService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.abm_services.student_reward_services.AddRewardStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AutomaticRewardGrantingService {

    StudentClassroomRepository studentClassroomRepository;
    StudentProjectRepository studentProjectRepository;
    StudentActivityRepository studentActivityRepository;
    RewardRepository rewardRepository;
    EvaluateConditionForStudentService evaluateConditionForStudentService;
    AddRewardStudentService addRewardStudentService;
    GetProjectService getProjectService;

    public void execute(Long studentId, Long targetId, String targetType) {
        ArrayList<Reward> rewards = new ArrayList<>();
        rewards.addAll(rewardRepository.findByTargetId(targetId));
        rewards.addAll(rewardRepository.findByRewardType("BADGE"));

        rewards.forEach(r -> {
            if (evaluateConditionForStudentService.execute(r.getId(), studentId)){
                addRewardStudentService.execute(r.getId(), studentId);
            }

        });
    }
}
