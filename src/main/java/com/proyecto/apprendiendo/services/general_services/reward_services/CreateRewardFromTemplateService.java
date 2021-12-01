package com.proyecto.apprendiendo.services.general_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.RewardTemplateDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.services.general_services.condition_services.CreateConditionFromTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateRewardFromTemplateService {

    private RewardRepository rewardRepository;
    private CreateConditionFromTemplateService createConditionFromTemplateService;

    public Long execute(RewardTemplateDTO rewardTemplateDTO, Long targetId, String targetType) {
        Reward reward = Reward.builder()
                              .rewardType(rewardTemplateDTO.getRewardType())
                              .text(rewardTemplateDTO.getText())
                              .conditionId(createConditionFromTemplateService.execute(rewardTemplateDTO.getCondition()))
                              .name(rewardTemplateDTO.getName())
                              .text(rewardTemplateDTO.getText())
                              .imageData(rewardTemplateDTO.getImageData())
                              .targetId(targetId)
                              .targetType(targetType)
                              .text(rewardTemplateDTO.getText())
                              .build();
        return rewardRepository.save(reward).getId();
    }
}
