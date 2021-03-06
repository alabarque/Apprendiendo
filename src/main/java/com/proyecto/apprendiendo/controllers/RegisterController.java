package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.general_services.user_services.CreateUserService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {

    CreateUserService createUserService;
    private ResponseDecorator responseDecorator;

    @PostMapping(value = "register/student")
    public ResponseEntity<Long> registerStudent(@RequestBody UserDTO userDTO) {
        return responseDecorator.decorate(() -> createUserService.execute(userDTO, UserType.STUDENT));
    }

    @PostMapping(value = "register/teacher")
    public ResponseEntity<Long> registerTeacher(@RequestBody UserDTO userDTO) {
        return responseDecorator.decorate(() -> createUserService.execute(userDTO, UserType.TEACHER));
    }

    //Temporal, de momento esta para tests
    @PostMapping(value = "register/admin")
    public ResponseEntity<Long> registerAdmin(@RequestBody UserDTO userDTO) {
        return responseDecorator.decorate(() -> createUserService.execute(userDTO, UserType.ADMIN));
    }

}
