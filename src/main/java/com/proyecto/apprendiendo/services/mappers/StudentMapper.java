package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentMapper {

    public static StudentDTO entityToDto(User user){
        return StudentDTO.builder()
                         .id(user.getId())
                         .username(user.getUsername())
                         .build();

    }
}
