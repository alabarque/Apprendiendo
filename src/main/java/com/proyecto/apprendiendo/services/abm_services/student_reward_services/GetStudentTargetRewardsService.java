package com.proyecto.apprendiendo.services.abm_services.student_reward_services;

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
public class GetStudentTargetRewardsService {

    private StudentRewardRepository studentRewardRepository;
    private RewardRepository rewardRepository;

    public ArrayList<RewardDTO> execute(Long studentId, Long projectId) {
        return rewardRepository.findByTargetId(projectId)
                               .stream()
                               .filter(r -> studentRewardRepository.findByStudentIdAndRewardId(studentId, r.getId()) != null)
                               .map(r -> RewardMapper.entityToDTO(r))
                               .collect(Collectors.toCollection(ArrayList::new));
    }
}
