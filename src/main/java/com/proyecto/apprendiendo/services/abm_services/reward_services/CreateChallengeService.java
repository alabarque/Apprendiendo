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
public class CreateChallengeService {

    private RewardRepository rewardRepository;

    public Long execute(ChallengeDTO challengeDTO) {
        Reward reward = Reward.builder().rewardType("CHALLENGE").text(challengeDTO.getText()).conditionId(challengeDTO.getConditionId()).name(challengeDTO.getName()).text(challengeDTO.getText()).imageData(challengeDTO.getImageData()).targetId(challengeDTO.getTargetId()).build();
        return rewardRepository.save(reward).getId();
    }
}
