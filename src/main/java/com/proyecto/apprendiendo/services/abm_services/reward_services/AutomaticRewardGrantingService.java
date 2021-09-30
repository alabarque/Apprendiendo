package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.condition_services.EvaluateConditionForStudentService;
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

    public void execute(Long studentId, Long targetId, String targetType) {

        ArrayList<Reward> rewards = new ArrayList<>();
        if (targetType.equals("PROJECT")) rewards = rewardRepository.findByTargetId(studentProjectRepository.findByUserIdAndProjectId(studentId,targetId).getId());
        if (targetType.equals("ACTIVITY")) rewards = rewardRepository.findByTargetId(studentActivityRepository.findByUserIdAndActivityId(studentId,targetId).getId());
        if (targetType.equals("CLASSROOM")) rewards = rewardRepository.findByTargetId(studentClassroomRepository.findByStudentIdAndClassroomId(studentId,targetId).getId());
        rewards.forEach(r -> {if (evaluateConditionForStudentService.execute(r.getId(),studentId)) addRewardStudentService.execute(r.getId(),studentId);});
    }
}
