package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetUsersService {

    private UserRepository userRepository;

    public ArrayList<UserDTO> execute() {
        return userRepository.findAll().stream().map(u -> UserMapper.entityToDto(u)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<UserDTO> execute(String role) {
        return userRepository.findByRole(role).stream().map(u -> UserMapper.entityToDto(u)).collect(Collectors.toCollection(ArrayList::new));
    }


}
