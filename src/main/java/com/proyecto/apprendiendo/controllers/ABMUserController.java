package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.DeleteClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.UpdateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetStudentClassroomsService;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.GetStudentProjectsService;
import com.proyecto.apprendiendo.services.abm_services.user_services.CreateUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.DeleteUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.UpdateUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ABMUserController {

    private CreateUserService createUserService;
    private GetUserService getUserService;
    private DeleteUserService deleteUserService;
    private UpdateUserService updateUserService;
    private GetStudentProjectsService getStudentProjectsService;
    private GetStudentClassroomsService getStudentClassroomsService;

    //Por ahora se usa el /register/
    //@PostMapping(path = "user")
    //public void newUser(@RequestBody UserNewDTO userNewDTO){
    //    createUserService.execute(userNewDTO);
    //}

    @GetMapping (path = "user/{userId}")
    public UserDTO getUser(@PathVariable Long userId){
        return getUserService.execute(userId);
    }

    @DeleteMapping(path = "user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        deleteUserService.execute(userId);
    }

    @PutMapping(path = "user")
    public void updateUser(@RequestBody UserDTO userDTO){
        updateUserService.execute(userDTO);
    }

    @GetMapping(path = "user/{userId}/classrooms")
    public ArrayList<ClassroomDTO> getStudentClassrooms(@PathVariable("userId") Long userId) {
        return getStudentClassroomsService.execute(userId);
    }

    @GetMapping(path = "user/{userId}/projects")
    public ArrayList<ProjectDTO> getStudentProjects(@PathVariable("userId") Long userId) {
        return getStudentProjectsService.execute(userId);
    }
}
