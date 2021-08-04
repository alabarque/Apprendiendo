package com.proyecto.apprendiendo.services.UserService;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.UserDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserService {

    private UserRepository userRepository;

    public UserDTO execute(Long projectId) {
        User user = userRepository.getById(projectId);
        return UserMapper.entityToDto(user);
    }
}
