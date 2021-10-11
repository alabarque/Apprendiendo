package com.proyecto.apprendiendo.services.general_services.activity_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ActivityRepository;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetActivityProjectService {

    private ActivityRepository activityRepository;
    private GetLessonService getLessonService;
    private GetProjectService getProjectService;

    public ProjectDTO execute(Long activityId) {
        Activity activity = activityRepository.getById(activityId);

        return getProjectService.execute(getLessonService.execute(activity.getLessonId()).getProjectId());
    }
}
