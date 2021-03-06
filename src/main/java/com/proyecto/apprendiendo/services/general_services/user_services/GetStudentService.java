package com.proyecto.apprendiendo.services.general_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentService {

    private UserRepository userRepository;

    public UserDTO execute(Long userId) {
        User user = userRepository.getById(userId);
        return StudentMapper.entityToDto(user);
    }

    public UserDTO execute(String username) {
        User user = userRepository.findByUsername(username);
        return StudentMapper.entityToDto(user);
    }


}
