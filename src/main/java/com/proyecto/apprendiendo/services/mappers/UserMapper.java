package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.LoginUserDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.UserDTO;

public class UserMapper {
    public static User DTOtoEntity(UserDTO userDTO){
        return User.builder().username(userDTO.getUsername())
                             .password(userDTO.getPassword())
                             .id(userDTO.getId())
                             .role(userDTO.getRole())
                             .build();

    }
    public static User DTOtoEntity(LoginUserDTO loginUserDTO){
        return User.builder().username(loginUserDTO.getUsername()).password(loginUserDTO.getPassword()).build();
    }
    public static UserDTO entityToDto(User user){

        return UserDTO.builder().id(user.getId())
                         .username(user.getUsername())
                         .password(user.getPassword())
                         .role(user.getRole())
                         .id(user.getId())
                         .build();

    }
}
