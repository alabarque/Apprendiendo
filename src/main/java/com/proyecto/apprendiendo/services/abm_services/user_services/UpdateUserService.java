package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateUserService {

    private UserRepository userRepository;

    public void execute(UserDTO userDTO){
        User user = userRepository.getById(userDTO.getId());

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        userRepository.save(user);
    }
}
