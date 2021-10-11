package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityClassroomService {

    private ActivityRepository activityRepository;
    private GetLessonClassroomService getLessonClassroomService;

    public ClassroomDTO execute(Long activityId) {
        Activity activity = activityRepository.getById(activityId);

        return getLessonClassroomService.execute(activity.getLessonId());
    }
}
