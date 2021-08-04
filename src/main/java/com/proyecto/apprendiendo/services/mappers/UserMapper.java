package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;

public class UserMapper {
    public static User DTOtoEntity(UserDTO userDTO){
        return User.builder().username(userDTO.getUsername()).password(userDTO.getPassword()).build();
    }
}
