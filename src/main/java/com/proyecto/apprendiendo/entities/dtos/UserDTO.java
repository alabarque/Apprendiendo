package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.Avatar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

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

    protected Long avatarId;
    protected AvatarDTO avatar;
    protected Integer studentYear;
    protected String studentDivision;
    protected String imageData;

    protected ArrayList<ClassroomDTO> studentClassrooms;
    protected ArrayList<RewardDTO> studentRewards;
    protected ArrayList<ClassroomDTO> teacherClassrooms;
    }
