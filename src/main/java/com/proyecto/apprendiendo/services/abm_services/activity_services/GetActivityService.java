package com.proyecto.apprendiendo.services.abm_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityService {

    private ActivityRepository activityRepository;

    public ActivityDTO execute(Long idClass) {
        Activity activity = activityRepository.getById(idClass);
        return ActivityMapper.entityToDto(activity);
    }
}
