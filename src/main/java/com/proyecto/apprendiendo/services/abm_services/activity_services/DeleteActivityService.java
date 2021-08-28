package com.proyecto.apprendiendo.services.abm_services.activity_services;

import com.proyecto.apprendiendo.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteActivityService {

    private ActivityRepository activityRepository;

    public Long execute(Long activityId){
        activityRepository.deleteById(activityId);
        return activityId;
    }
}
