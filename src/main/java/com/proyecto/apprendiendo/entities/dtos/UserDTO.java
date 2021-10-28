package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.Avatar;
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
    protected String token;

    protected String firstName;
    protected String lastName;
    protected String homePhone;
    protected String mobilePhone;
    protected String address;

    protected Long avatarId; //FK a Avatar
    protected AvatarDTO avatar;
    protected Integer studentYear;
    protected String studentDivision;
    protected String imageData;
}
