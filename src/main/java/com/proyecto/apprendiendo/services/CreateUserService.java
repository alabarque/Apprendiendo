package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateUserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;
    UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(UserDTO userDTO, UserType userType) {
        User user = UserMapper.DTOtoEntity(userDTO);
        user.setRole(userType.getValue());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }
}
