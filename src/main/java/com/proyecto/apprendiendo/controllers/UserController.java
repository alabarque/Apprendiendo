package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.avatar_services.GetStudentAvailableAvatarPartsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetUserClassroomsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.UpdateStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.general_services.document_services.*;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetStudentLessonProgressService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetSubRewardsService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.UpdateStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.UpdateStudentProjectProgressService;
import com.proyecto.apprendiendo.services.general_services.student_reward_services.*;
import com.proyecto.apprendiendo.services.general_services.user_services.DeleteUserService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetUserService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetUsersService;
import com.proyecto.apprendiendo.services.general_services.user_services.UpdateUserService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class UserController {

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
    private GetStudentClassroomProgressService getStudentClassroomProgressService;
    private UpdateStudentClassroomProgressService updateStudentClassroomProgressService;
    private GetUsersService getUsersService;
    private GetStudentLessonProgressService getStudentLessonProgressService;
    private GetStudentAvailableAvatarPartsService getStudentAvailableAvatarPartsService;
    private AddStudentTargetDocumentService addStudentTargetDocumentService;
    private GetStudentSourcesDocumentsService getStudentSourcesDocumentsService;
    private GetStudentTargetSubRewardsService getStudentTargetSubRewardsService;


    @GetMapping(path = "user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        return responseDecorator.decorate(() -> getUserService.execute(userId));
    }

    @DeleteMapping(path = "user/{userId}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long userId) {
        return responseDecorator.decorate(() -> deleteUserService.execute(userId));
    }

    @PutMapping(path = "user")
    public ResponseEntity<Long> updateUser(@RequestBody UserDTO userDTO) {
        return responseDecorator.decorate(() -> updateUserService.execute(userDTO));
    }

    @GetMapping(path = "user/{userId}/classrooms")
    public ResponseEntity<ArrayList<ClassroomDTO>> getUserClassrooms(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getUserClassroomsService.execute(userId));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/progress")
    public ResponseEntity<StudentActivityDTO> getStudentActivityProgress(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentActivityProgressService.execute(userId, activityId));
    }

    @PutMapping(path = "user/{userId}/activity/{activityId}/progress")
    public ResponseEntity<Long> updateStudentActivityProgress(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId, @RequestBody StudentActivityDTO studentActivityDTO) {
        return responseDecorator.decorate(() -> updateStudentActivityProgressService.execute(userId, activityId, studentActivityDTO));
    }

    @GetMapping(path = "user/{userId}/lesson/{lessonId}/progress")
    public ResponseEntity<StudentLessonDTO> getStudentLessonProgress(@PathVariable("lessonId") Long lessonId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentLessonProgressService.execute(userId, lessonId));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/progress")
    public ResponseEntity<StudentProjectDTO> getStudentProjectProgress(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentProjectProgressService.execute(userId, projectId));
    }

    @PutMapping(path = "user/{userId}/project/{projectId}/progress")
    public ResponseEntity<Long> updateStudentProjectProgress(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId, @RequestBody StudentProjectDTO studentProjectDTO) {
        return responseDecorator.decorate(() -> updateStudentProjectProgressService.execute(userId, projectId, studentProjectDTO));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/progress")
    public ResponseEntity<StudentClassroomDTO> getStudentClassroomProgress(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentClassroomProgressService.execute(userId, classroomId));
    }

    @PutMapping(path = "user/{userId}/classroom/{classroomId}/progress")
    public ResponseEntity<Long> updateStudentClassroomProgress(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId, @RequestBody StudentClassroomDTO studentClassroomDTO) {
        return responseDecorator.decorate(() -> updateStudentClassroomProgressService.execute(userId, classroomId, studentClassroomDTO));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentActivityDocuments(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, activityId, "ACTIVITY"));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentActivityDocumentsSummary(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, activityId, "ACTIVITY", "SUMMARY"));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentActivityDocumentsSelective(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId, @RequestParam(required = false) String type) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, activityId, "ACTIVITY", "SELECTIVE", type));
    }

    @PostMapping(path = "user/{userId}/activity/{activityId}/document")
    public ResponseEntity<Long> addStudentActivityDocument(@PathVariable("activityId") Long activityId, @PathVariable("userId") Long userId, @RequestBody DocumentDTO documentDTO) {
        return responseDecorator.decorate(() -> addStudentTargetDocumentService.execute(userId, activityId,"ACTIVITY", documentDTO));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentProjectDocuments(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, projectId, "PROJECT"));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentProjectDocumentsSummary(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, projectId, "PROJECT", "SUMMARY"));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentProjectDocumentsSelective(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId, @RequestParam(required = false) String type) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, projectId, "PROJECT", "SELECTIVE", type));
    }

    @PostMapping(path = "user/{userId}/project/{projectId}/document")
    public ResponseEntity<Long> addStudentProjectDocument(@PathVariable("projectId") Long projectId, @PathVariable("userId") Long userId, @RequestBody DocumentDTO documentDTO) {
        return responseDecorator.decorate(() -> addStudentTargetDocumentService.execute(userId, projectId, "PROJECT", documentDTO));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentClassroomDocuments(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, classroomId, "CLASSROOM"));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentClassroomDocumentsSummary(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, classroomId, "CLASSROOM", "SUMMARY"));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getStudentClassroomDocumentsSelective(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId, @RequestParam(required = false) String type) {
        return responseDecorator.decorate(() -> getStudentSourcesDocumentsService.execute(userId, classroomId, "CLASSROOM", "SELECTIVE", type));
    }

    @PostMapping(path = "user/{userId}/classroom/{classroomId}/document")
    public ResponseEntity<Long> addStudentClassroomDocument(@PathVariable("classroomId") Long classroomId, @PathVariable("userId") Long userId, @RequestBody DocumentDTO documentDTO) {
        return responseDecorator.decorate(() -> addStudentTargetDocumentService.execute(userId, classroomId,"CLASSROOM" , documentDTO));
    }

    @GetMapping(path = "user/{userId}/socialRewards")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentSocialRewards(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentRewardsService.execute(userId, "SOCIAL"));
    }

    @GetMapping(path = "user/{userId}/badges")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentBadges(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentRewardsService.execute(userId, "BADGE"));
    }

    @GetMapping(path = "user/{userId}/achievements")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentAchievements(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentRewardsService.execute(userId, "ACHIEVEMENT"));
    }

    @GetMapping(path = "user/{userId}/challenges")
    public ResponseEntity<ArrayList<RewardDTO>> getStudentChallenges(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentRewardsService.execute(userId, "CHALLENGE"));
    }

    @GetMapping(path = "user/{userId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewards(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentRewardsService.execute(userId, "ANY"));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromClassroom(@PathVariable("userId") Long userId, @PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getStudentTargetRewardsService.execute(userId, classroomId));
    }

    @GetMapping(path = "user/{userId}/classroom/{classroomId}/rewards/all")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentSubRewardsFromClassroom(@PathVariable("userId") Long userId, @PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getStudentTargetSubRewardsService.execute(userId, classroomId, "CLASSROOM"));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getStudentTargetRewardsService.execute(userId, projectId));
    }

    @GetMapping(path = "user/{userId}/project/{projectId}/rewards/all")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentSubRewardsFromProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getStudentTargetSubRewardsService.execute(userId, projectId, "PROJECT"));
    }

    @GetMapping(path = "user/{userId}/activity/{activityId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getAllStudentRewardsFromActivity(@PathVariable("userId") Long userId, @PathVariable("activityId") Long activityId) {
        return responseDecorator.decorate(() -> getStudentTargetRewardsService.execute(userId, activityId));
    }

    @PostMapping(path = "user/{userId}/reward/{rewardId}")
    public ResponseEntity<Long> giveRewardToStudent(@PathVariable("userId") Long userId, @PathVariable("rewardId") Long rewardId) {
        return responseDecorator.decorate(() -> addRewardStudentService.execute(rewardId, userId));
    }

    @DeleteMapping(path = "user/{userId}/reward/{rewardId}")
    public ResponseEntity<Long> removeRewardFromStudent(@PathVariable("userId") Long userId, @PathVariable("rewardId") Long rewardId) {
        return responseDecorator.decorate(() -> removeRewardStudentService.execute(rewardId, userId));
    }

    @GetMapping(path = "user/{userId}/avatar/parts/available")
    public ResponseEntity<ArrayList<String>> getStudentAvailableAcatarParts(@PathVariable("userId") Long userId) {
        return responseDecorator.decorate(() -> getStudentAvailableAvatarPartsService.execute(userId));
    }

    @GetMapping(path = "users")
    public ResponseEntity<ArrayList<UserDTO>> getAllUsers() {
        return responseDecorator.decorate(() -> getUsersService.execute());
    }

    @GetMapping(path = "users/students")
    public ResponseEntity<ArrayList<UserDTO>> getAllStudents() {
        return responseDecorator.decorate(() -> getUsersService.execute("ROLE_STUDENT"));
    }

    @GetMapping(path = "users/teachers")
    public ResponseEntity<ArrayList<UserDTO>> getAllTeachers() {
        return responseDecorator.decorate(() -> getUsersService.execute("ROLE_TEACHER"));
    }

    @GetMapping(path = "users/admins")
    public ResponseEntity<ArrayList<UserDTO>> getAllAdmins() {
        return responseDecorator.decorate(() -> getUsersService.execute("ROLE_ADMIN"));
    }



}
