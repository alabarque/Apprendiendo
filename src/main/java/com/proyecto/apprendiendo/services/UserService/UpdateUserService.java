package com.proyecto.apprendiendo.services.UserService;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.UserDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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
