package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;

public class UserMapper {
    public static User DTOtoEntity(UserDTO userDTO) {
        return User.builder()
                   .username(userDTO.getUsername())
                   .password(userDTO.getPassword())
                   .firstName(userDTO.getFirstName())
                   .lastName(userDTO.getLastName())
                   .homePhone(userDTO.getHomePhone())
                   .mobilePhone(userDTO.getMobilePhone())
                   .address(userDTO.getAddress())
                   .avatarId(userDTO.getAvatarId())
                   .id(userDTO.getId())
                   .role(userDTO.getRole())
                   .imageData(userDTO.getImageData())
                   .studentDivision(userDTO.getStudentDivision())
                   .studentYear(userDTO.getStudentYear())
                   .build();

    }

    public static UserDTO entityToDto(User user) {
        return UserDTO.builder()
                      .id(user.getId())
                      .username(user.getUsername())
                      .firstName(user.getFirstName())
                      .lastName(user.getLastName())
                      .homePhone(user.getHomePhone())
                      .mobilePhone(user.getMobilePhone())
                      .address(user.getAddress())
                      .avatarId(user.getAvatarId())
                      .role(user.getRole())
                      .imageData(user.getImageData())
                      .studentDivision(user.getStudentDivision())
                      .studentYear(user.getStudentYear())
                      .build();

    }
}
