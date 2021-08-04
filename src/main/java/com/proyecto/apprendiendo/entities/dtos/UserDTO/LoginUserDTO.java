package com.proyecto.apprendiendo.entities.dtos.UserDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginUserDTO {
    private String username;
    private String password;
}
