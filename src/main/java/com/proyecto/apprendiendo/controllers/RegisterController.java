package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ResponseIdDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.LoginUserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.UserService.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {

    CreateUserService createUserService;

    @PostMapping(value = "/register/student")
    public ResponseIdDTO registerStudent(@RequestBody LoginUserDTO loginUserDTO){
         Long id = createUserService.execute(loginUserDTO, UserType.STUDENT);
         return ResponseIdDTO.builder().id(id).build();
    }

    @PostMapping(value = "/register/teacher")
    public ResponseIdDTO registerTeacher(@RequestBody LoginUserDTO loginUserDTO){
        Long id = createUserService.execute(loginUserDTO, UserType.TEACHER);
        return ResponseIdDTO.builder().id(id).build();
    }


    //Temporal, de momento esta para tests
    @PostMapping(value = "/register/admin")
    public ResponseIdDTO registerAdmin(@RequestBody LoginUserDTO loginUserDTO){
        Long id = createUserService.execute(loginUserDTO, UserType.ADMIN);
        return ResponseIdDTO.builder().id(id).build();
    }

}
