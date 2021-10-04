package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.repositories.StudentRewardRepository;
import com.proyecto.apprendiendo.services.mappers.AvatarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentAvailableAvatarPartsService {

    private StudentRewardRepository studentRewardRepository;
    private RewardRepository rewardRepository;

    public ArrayList<String> execute(Long studentId) {
        var rewards = studentRewardRepository.findByStudentIdAndRewardType(studentId, "AVATAR");
        return rewards.stream()
                      .map(r -> rewardRepository.getById(r.getRewardId()).getData())
                      .collect(Collectors.toCollection(ArrayList::new));
    }
}
