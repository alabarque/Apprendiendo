package com.proyecto.apprendiendo.services.general_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CreateUserService {

    PasswordEncoder passwordEncoder;
    UserDetailsService userDetailsService;
    UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(UserDTO userDTO, UserType userType) {
        return Optional.ofNullable(userRepository.findByUsername(userDTO.getUsername()))
                       .map(User::getId)
                       .orElseGet(() -> this.saveUser(userDTO, userType));
    }

    private Long saveUser(UserDTO userDTO, UserType userType) {
        User user = UserMapper.DTOtoEntity(userDTO);
        user.setRole("ROLE_" + userType.getValue());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }
}
