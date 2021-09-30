package com.proyecto.apprendiendo.services.abm_services.student_reward_services;

import com.proyecto.apprendiendo.entities.StudentReward;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentRewardsService {

    private RewardRepository rewardRepository;
    private StudentRewardRepository studentRewardRepository;

    public ArrayList<RewardDTO> execute(Long studentId, String rewardType) {
        if (rewardType.equals("ANY")) {
            ArrayList<StudentReward> studentRewards = studentRewardRepository.findByStudentId(studentId);
            return studentRewards.stream()
                                 .map(ps -> RewardMapper.entityToDTO(rewardRepository.getById(ps.getRewardId())))
                                 .collect(Collectors.toCollection(ArrayList::new));
        } else {
            ArrayList<StudentReward> studentRewards = studentRewardRepository.findByStudentIdAndRewardType(studentId, rewardType);
            return studentRewards.stream()
                                 .map(ps -> RewardMapper.entityToDTO(rewardRepository.getById(ps.getRewardId())))
                                 .collect(Collectors.toCollection(ArrayList::new));
        }

    }
}
