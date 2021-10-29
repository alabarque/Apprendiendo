package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class StudentDTO {
    protected Long id;
    protected String username;
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
}
