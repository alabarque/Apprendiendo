package com.proyecto.apprendiendo.entities.dtos.UserDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
    protected Long id;
    protected String username;
    protected String password;
    protected String role;
}
