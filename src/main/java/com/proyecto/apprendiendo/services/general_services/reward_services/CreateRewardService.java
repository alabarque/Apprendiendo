package com.proyecto.apprendiendo.services.general_services.reward_services;

import com.proyecto.apprendiendo.entities.Reward;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.RewardRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityClassroomService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class CreateRewardService {

    private RewardRepository rewardRepository;
    private GetActivityClassroomService getActivityClassroomService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private GetProjectService getProjectService;
    private AutomaticRewardGrantingService automaticRewardGrantingService;

    public Long execute(RewardDTO rewardDTO) {
        Reward reward = Reward.builder()
                              .rewardType(rewardDTO.getRewardType())
                              .text(rewardDTO.getText())
                              .conditionId(rewardDTO.getConditionId())
                              .name(rewardDTO.getName())
                              .text(rewardDTO.getText())
                              .imageData(rewardDTO.getImageData())
                              .targetId(rewardDTO.getTargetId())
                              .targetType(rewardDTO.getTargetType())
                              .data(rewardDTO.getData())
                              .build();
        Long rewardId = rewardRepository.save(reward).getId();


        if (rewardDTO.getTargetType() == null) return rewardId;

        if (rewardDTO.getTargetType().equals("ACTIVITY")){
            ClassroomDTO classroomDTO = getActivityClassroomService.execute(reward.getTargetId());
            ArrayList<UserDTO> students = getClassroomStudentsService.execute(classroomDTO.getId());
            students.forEach(student -> automaticRewardGrantingService.execute(student.getId(), rewardDTO.getTargetId(), "ACTIVITY"));
        }

        if (rewardDTO.getTargetType().equals("PROJECT")){
            Long classroomId = getProjectService.execute(rewardDTO.getTargetId()).getClassroomId();
            ArrayList<UserDTO> students = getClassroomStudentsService.execute(classroomId);
            students.forEach(student -> automaticRewardGrantingService.execute(student.getId(), rewardDTO.getTargetId(), "PROJECT"));
        }

        if (rewardDTO.getTargetType().equals("CLASSROOM")){
            ArrayList<UserDTO> students = getClassroomStudentsService.execute(rewardDTO.getTargetId());
            students.forEach(student -> automaticRewardGrantingService.execute(student.getId(), rewardDTO.getTargetId(), "CLASSROOM"));
        }

        return  rewardId;
    }
}
