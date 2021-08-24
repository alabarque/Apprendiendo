package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserLoginDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import lombok.AllArgsConstructor;

public class UserMapper {
    public static User DTOtoEntity(UserDTO userDTO){
        return User.builder()
                   .username(userDTO.getUsername())
                   .password(userDTO.getPassword())
                   .id(userDTO.getId())
                   .role(userDTO.getRole())
                   .build();

    }
    public static User DTOtoEntity(UserLoginDTO userLoginDTO){
        return User.builder()
                   .username(userLoginDTO.getUsername())
                   .password(userLoginDTO.getPassword())
                   .build();
    }
    public static UserDTO entityToDto(User user){

        return UserDTO.builder()
                      .id(user.getId())
                      .username(user.getUsername())
                      .password(user.getPassword())
                      .role(user.getRole())
                      .build();

    }
}
