package com.proyecto.apprendiendo.services.abm_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateActivityService {

    private ActivityRepository activityRepository;

    public Long execute(ActivityDTO activityDTO) {
        Activity activity = Activity.builder().name(activityDTO.getName()).projectId(activityDTO.getProjectId()).previousActivityId(activityDTO.getPreviousActivityId()).challengeId(activityDTO.getChallengeId()).description(activityDTO.getDescription()).build();
        return activityRepository.save(activity).getId();
    }
}
