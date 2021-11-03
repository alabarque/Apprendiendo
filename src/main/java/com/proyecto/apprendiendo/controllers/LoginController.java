package com.proyecto.apprendiendo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.dtos.UserLoginDTO;
import com.proyecto.apprendiendo.services.general_services.user_services.GetUserService;
import com.proyecto.apprendiendo.services.login_services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final GetUserService getUserService;
    private final ObjectMapper objectMapper;

    @CrossOrigin
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO request) throws IOException {
        try {
            String token = loginService.execute(request);
            UserDTO userDTO = getUserService.execute(request.getUsername());
            userDTO.setToken(token);

            return ResponseEntity.ok()
                                 .header(HttpHeaders.AUTHORIZATION, token)
                                 .body(objectMapper.writeValueAsString(userDTO));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
