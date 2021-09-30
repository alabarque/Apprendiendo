package com.proyecto.apprendiendo.services.abm_services.student_reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.StudentReward;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddRewardStudentService {

    private StudentRewardRepository studentRewardRepository;
    private RewardRepository rewardRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long rewardId, Long studentId) {
        Reward reward = rewardRepository.getById(rewardId);
        studentRewardRepository.save(StudentReward.builder()
                                                  .rewardType(reward.getRewardType())
                                                  .rewardId(rewardId)
                                                  .studentId(studentId)
                                                  .build());
        return rewardId;
    }
}
