package com.proyecto.apprendiendo.services.UserService;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO.LoginUserDTO;
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
public class CreateUserService {

    PasswordEncoder passwordEncoder;
    UserDetailsService userDetailsService;
    UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(LoginUserDTO loginUserDTO, UserType userType) {
            return Optional.ofNullable(userRepository.findByUsername(loginUserDTO.getUsername())).map(User::getId).orElseGet(() -> this.saveUser(loginUserDTO, userType));
    }

    private Long saveUser(LoginUserDTO loginUserDTO, UserType userType) {
        User user = UserMapper.DTOtoEntity(loginUserDTO);
        user.setRole("ROLE_" + userType.getValue());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }
}
