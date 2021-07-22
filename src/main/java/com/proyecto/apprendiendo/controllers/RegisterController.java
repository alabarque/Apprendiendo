package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {

    CreateUserService createUserService;

    @PostMapping(value = "/register/student")
    public void registerStudent(@RequestBody UserDTO userDTO){
        createUserService.execute(userDTO, UserType.STUDENT);
    }

    @PostMapping(value = "/register/teacher")
    public void registerTeacher(@RequestBody UserDTO userDTO){
        createUserService.execute(userDTO, UserType.TEACHER);
    }

}
