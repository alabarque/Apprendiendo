package com.proyecto.apprendiendo.services.general_services.user_services;

import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserRole;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
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

    public ArrayList<Object> execute() {
        return userRepository.findAll()
                             .stream()
                             .map(u -> {
                                 if (u.getRole().equals(UserRole.ROLE_STUDENT.toString())) return StudentMapper.entityToDto(u);
                                 else return UserMapper.entityToDto(u);
                             })
                             .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Object> execute(String role) {
        return userRepository.findByRole(role)
                             .stream()
                             .map(u -> {
                                 if (u.getRole().equals(UserRole.ROLE_STUDENT.toString())) return StudentMapper.entityToDto(u);
                                 else return UserMapper.entityToDto(u);
                             })
                             .collect(Collectors.toCollection(ArrayList::new));
    }


}
