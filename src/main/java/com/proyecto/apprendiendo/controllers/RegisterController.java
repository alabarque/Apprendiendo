package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ResponseIdDTO;
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
    public ResponseIdDTO registerStudent(@RequestBody UserDTO userDTO){
         Long id = createUserService.execute(userDTO, UserType.STUDENT);
         return ResponseIdDTO.builder().id(id).build();
    }

    @PostMapping(value = "/register/teacher")
    public ResponseIdDTO registerTeacher(@RequestBody UserDTO userDTO){
        Long id = createUserService.execute(userDTO, UserType.TEACHER);
        return ResponseIdDTO.builder().id(id).build();
    }


    //Temporal, de momento esta para tests
    @PostMapping(value = "/register/admin")
    public ResponseIdDTO registerAdmin(@RequestBody UserDTO userDTO){
        Long id = createUserService.execute(userDTO, UserType.ADMIN);
        return ResponseIdDTO.builder().id(id).build();
    }

}
