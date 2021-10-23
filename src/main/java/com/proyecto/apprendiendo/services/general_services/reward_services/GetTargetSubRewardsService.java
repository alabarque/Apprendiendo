package com.proyecto.apprendiendo.services.general_services.reward_services;

import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomProjectsService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonActivitiesService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectLessonsService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class GetTargetSubRewardsService {

    private GetTargetRewardsService getTargetRewardsService;
    private GetClassroomProjectsService getClassroomProjectsService;
    private GetProjectLessonsService getProjectLessonsService;
    private GetLessonActivitiesService getLessonActivitiesService;

    public ArrayList<RewardDTO> execute(Long targetId, String targetType) {

        if(targetType.equals(TargetType.CLASSROOM.getValue())) return getClassroomSubRewards(targetId) ;

        if(targetType.equals(TargetType.PROJECT.getValue())) return getProjectSubRewards(targetId);

        if(targetType.equals(TargetType.ACTIVITY.getValue())) return getTargetRewardsService.execute(targetId);

        else return null;

    }

    private ArrayList<RewardDTO> getProjectSubRewards(Long projectId){
        return Stream.concat(
                getTargetRewardsService.execute(projectId).stream(),
                getProjectLessonsService.execute(projectId)
                                              .stream()
                                              .flatMap(l -> getLessonActivitiesService.execute(l.getId()).stream())
                                              .flatMap(a -> getTargetRewardsService.execute(a.getId()).stream())
        ).collect(Collectors.toCollection(ArrayList::new));

    }

    private ArrayList<RewardDTO> getClassroomSubRewards(Long classroomId){
        return Stream.concat(
                getTargetRewardsService.execute(classroomId).stream(),
                getClassroomProjectsService.execute(classroomId)
                                       .stream()
                                       .flatMap(p -> getProjectSubRewards(p.getId()).stream())
        ).collect(Collectors.toCollection(ArrayList::new));
    }

}
