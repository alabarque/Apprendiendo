package com.proyecto.apprendiendo.services.general_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetUserService {

    private UserRepository userRepository;

    public UserDTO execute(Long userId) {
        User user = userRepository.getById(userId);
        return UserMapper.entityToDto(user);
    }

    public UserDTO execute(String username) {
        User user = userRepository.findByUsername(username);
        return UserMapper.entityToDto(user);
    }


}
