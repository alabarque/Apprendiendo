package com.proyecto.apprendiendo.services.abm_services.lesson_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetLessonActivitiesService {

    private ActivityRepository activityRepository;

    public ArrayList<ActivityDTO> execute(Long lessonId) {
        ArrayList<Activity> activities = activityRepository.findByLessonId(lessonId);
        return activities.stream().map(activity -> ActivityMapper.entityToDto(activity)).collect(Collectors.toCollection(ArrayList::new));
    }
}
