package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateActivityService {

    private ActivityRepository activityRepository;

    public Long execute(ActivityDTO activityDTO) {
        Activity activity = activityRepository.getById(activityDTO.getId());
        activity.setName(activityDTO.getName());
        activity.setDueDate(activityDTO.getDueDate());
        activity.setStartDate(activityDTO.getStartDate());
        activity.setPosition(activityDTO.getPosition());
        activityRepository.save(activity);
        return activityDTO.getId();
    }
}
