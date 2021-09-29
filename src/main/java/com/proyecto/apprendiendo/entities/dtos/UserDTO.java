package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
    protected Long id;
    protected Long avatarId; //FK a Avatar
    protected String username;
    protected String password;
    protected String role;
    protected String token;

    protected String firstName;
    protected String lastName;
    protected String homePhone;
    protected String mobilePhone;
    protected String address;
}
