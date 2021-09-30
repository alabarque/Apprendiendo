package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteUserService {

    private UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long userId) {
        userRepository.deleteById(userId);
        return userId;
    }
}
