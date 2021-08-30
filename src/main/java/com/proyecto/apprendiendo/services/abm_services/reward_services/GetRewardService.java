package com.proyecto.apprendiendo.services.abm_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetRewardService {

    private RewardRepository rewardRepository;

    public RewardDTO execute(Long idClass) {
        Reward reward = rewardRepository.getById(idClass);
        return RewardMapper.entityToRewardDTO(reward);
    }
}
