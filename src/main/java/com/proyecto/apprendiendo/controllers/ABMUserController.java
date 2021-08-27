package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetUserClassroomsService;
import com.proyecto.apprendiendo.services.abm_services.student_activity_services.*;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.UpdateStudentProjectProgressService;
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
}
