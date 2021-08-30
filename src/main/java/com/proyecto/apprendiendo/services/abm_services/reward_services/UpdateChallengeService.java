package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.ChallengeDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateChallengeService {

    private RewardRepository rewardRepository;

    public Long execute(ChallengeDTO challengeDTO){
        Reward reward = rewardRepository.getById(challengeDTO.getId());
        reward.setId(challengeDTO.getId());
        reward.setName(challengeDTO.getName());
        reward.setRewardType("CHALLENGE");
        reward.setConditionId(challengeDTO.getConditionId());
        reward.setImageData(challengeDTO.getImageData());
        reward.setTargetId(challengeDTO.getTargetId());
        reward.setText(reward.getText());
        rewardRepository.save(reward);
        return challengeDTO.getId();
    }
}
