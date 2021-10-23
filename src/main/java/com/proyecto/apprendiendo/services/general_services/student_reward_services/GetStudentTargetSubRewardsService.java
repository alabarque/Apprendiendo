package com.proyecto.apprendiendo.services.general_services.student_reward_services;

import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetSubRewardsService;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentTargetSubRewardsService {

    private StudentRewardRepository studentRewardRepository;
    private GetTargetSubRewardsService getTargetSubRewardsService;

    public ArrayList<RewardDTO> execute(Long studentId, Long projectId, String targetType) {
        return getTargetSubRewardsService.execute(projectId, targetType)
                                         .stream()
                                         .filter(r -> studentRewardRepository.findByStudentIdAndRewardId(studentId, r.getId()) != null)
                                         .collect(Collectors.toCollection(ArrayList::new));
    }
}
