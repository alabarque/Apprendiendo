package com.proyecto.apprendiendo.services.abm_services.student_reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.StudentReward;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddRewardStudentService {

    private StudentRewardRepository studentRewardRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long rewardId, Long studentId, String rewardType){
        studentRewardRepository.save(StudentReward.builder().rewardType(rewardType).rewardId(rewardId).studentId(studentId).build());
        return rewardId;
    }
}
