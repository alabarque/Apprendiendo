package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserService {

    private UserRepository userRepository;

    public void execute(Long projectId){
        userRepository.deleteById(projectId);
    }
}
