package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateUserService {

    PasswordEncoder passwordEncoder;
    UserDetailsService userDetailsService;
    UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(UserDTO userDTO, UserType userType) {
            return Optional.ofNullable(userRepository.findByUsername(userDTO.getUsername())).map(User::getId).orElseGet(() -> this.saveUser(userDTO, userType));
    }

    private Long saveUser(UserDTO userDTO, UserType userType) {
        User user = UserMapper.DTOtoEntity(userDTO);
        user.setRole("ROLE_" + userType.getValue());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }
}
