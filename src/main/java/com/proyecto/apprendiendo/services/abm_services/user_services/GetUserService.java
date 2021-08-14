package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserService {

    private UserRepository userRepository;

    public UserDTO execute(Long usertId) {
        User user = userRepository.getById(usertId);
        return UserMapper.entityToDto(user);
    }

    public UserDTO execute(String username) {
        User user = userRepository.findByUsername(username);
        return UserMapper.entityToDto(user);
    }


}
