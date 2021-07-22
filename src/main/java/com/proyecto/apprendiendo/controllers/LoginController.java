package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDTO request) {
        return null;
    }
}
