package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetUserClassroomsService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.*;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.UpdateStudentProjectProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_reward_services.AddRewardStudentService;
import com.proyecto.apprendiendo.services.abm_services.student_reward_services.GetStudentRewardsService;
import com.proyecto.apprendiendo.services.abm_services.student_reward_services.GetStudentTargetRewardsService;
import com.proyecto.apprendiendo.services.abm_services.student_reward_services.RemoveRewardStudentService;
import com.proyecto.apprendiendo.services.abm_services.user_services.DeleteUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.UpdateUserService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ABMUserController {

    private GetUserService getUserService;
    private DeleteUserService deleteUserService;
    private UpdateUserService updateUserService;
    private GetUserClassroomsService getUserClassroomsService;
    private ResponseDecorator responseDecorator;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private UpdateStudentActivityProgressService updateStudentActivityProgressService;
    private GetStudentProjectProgressService getStudentProjectProgressService;
    private UpdateStudentProjectProgressService updateStudentProjectProgressService;
    private GetStudentRewardsService getStudentRewardsService;
    private AddRewardStudentService addRewardStudentService;
    private RemoveRewardStudentService removeRewardStudentService;
    private GetStudentTargetRewardsService getStudentTargetRewardsService;

    //Por ahora se usa el /register/
    //@PostMapping(path = "user")
    //public void newUser(@RequestBody UserNewDTO userNewDTO){
    //    createUserService.execute(userNewDTO);
    //}

    @GetMapping (path = "user/{userId}")
    public ResponseEntity< UserDTO> getUser(@PathVariable Long userId){
        return responseDecorator.decorate(()-> getUserService.execute(userId));
    }

    @DeleteMapping(path = "user/{userId}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long userId){
        return responseDecorator.decorate(()->deleteUserService.execute(userId));
    }

    @PutMapping(path = "user")
    public ResponseEntity<Long> updateUser(@RequestBody UserDTO userDTO){
        return responseDecorator.decorate(()->updateUserService.execute(userDTO));
    }

    @GetMapping(path = "user/{userId}/classrooms")
    public ResponseEntity< ArrayList<ClassroomDTO>> getUserClassrooms(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getUserClassroomsService.execute(userId));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/progress")
    public ResponseEntity<StudentActivityDTO> getStudentActivityProgress(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentActivityProgressService.execute(userId, activityId));
    }

    @PutMapping(path = "user/{userId}/activity/{activityId}/progress")
    public ResponseEntity<Long> updateStudentActivityProgress(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId, @RequestBody StudentActivityDTO studentActivityDTO) {
        return responseDecorator.decorate(()-> updateStudentActivityProgressService.execute(userId, activityId, studentActivityDTO));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/progress")
    public ResponseEntity<StudentProjectDTO> getStudentProjectProgress(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentProjectProgressService.execute(userId, projectId));
    }

    @PutMapping(path = "user/{userId}/project/{projectId}/progress")
    public ResponseEntity<Long> updateStudentProjectProgress(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId, @RequestBody StudentProjectDTO studentProjectDTO) {
        return responseDecorator.decorate(()-> updateStudentProjectProgressService.execute(userId, projectId, studentProjectDTO));
    }

    @GetMapping(path = "user/{userId}/socialRewards")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentSocialRewards(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentRewardsService.execute(userId, "SOCIAL"));
    }

    @GetMapping(path = "user/{userId}/badges")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentBadges(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentRewardsService.execute(userId, "BADGE"));
    }

    @GetMapping(path = "user/{userId}/achievements")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentAchievements(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentRewardsService.execute(userId, "ACHIEVEMENT"));
    }

    @GetMapping(path = "user/{userId}/challenges")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentChallenges(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentRewardsService.execute(userId, "CHALLENGE"));
    }

    @GetMapping(path = "user/{userId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewards(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(()-> getStudentRewardsService.execute(userId, "ANY"));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromClassroom(@PathVariable("userId") Long userId, @PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(()-> getStudentTargetRewardsService.execute(userId, classroomId));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(()-> getStudentTargetRewardsService.execute(userId, projectId));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromActivity(@PathVariable("userId") Long userId, @PathVariable("activityId") Long activityId) {
        return responseDecorator.decorate(()-> getStudentTargetRewardsService.execute(userId, activityId));
    }

    @PostMapping(path = "user/{userId}/reward/{rewardId}")
    public ResponseEntity<Long> giveRewardToStudent(@PathVariable("userId") Long userId, @PathVariable("rewardId") Long rewardId) {
        return responseDecorator.decorate(()-> addRewardStudentService.execute(rewardId, userId));
    }

    @DeleteMapping(path = "user/{userId}/reward/{rewardId}")
    public ResponseEntity<Long> removeRewardFromStudent(@PathVariable("userId") Long userId, @PathVariable("rewardId") Long rewardId) {
        return responseDecorator.decorate(()-> removeRewardStudentService.execute(rewardId, userId));
    }


}
