package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentService {

    private UserRepository userRepository;

    public StudentDTO execute(Long usertId) {
        User user = userRepository.getById(usertId);
        return StudentMapper.entityToDto(user);
    }

    public StudentDTO execute(String username) {
        User user = userRepository.findByUsername(username);
        return StudentMapper.entityToDto(user);
    }


}
