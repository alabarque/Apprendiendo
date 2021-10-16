package com.proyecto.apprendiendo.services.general_services.reward_services;

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
public class GetTargetRewardsService {

    private RewardRepository rewardRepository;

    public ArrayList<RewardDTO> execute(Long targetId) {
        return rewardRepository.findByTargetId(targetId)
                               .stream()
                               .map(r -> RewardMapper.entityToDTO(r))
                               .collect(Collectors.toCollection(ArrayList::new));
    }
}
