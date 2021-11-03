package com.proyecto.apprendiendo.services.general_services.student_reward_services;

import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RemoveRewardStudentService {

    private StudentRewardRepository studentRewardRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long rewardId, Long studentId) {
        studentRewardRepository.deleteByStudentIdAndRewardId(studentId, rewardId);
        return rewardId;
    }
}
