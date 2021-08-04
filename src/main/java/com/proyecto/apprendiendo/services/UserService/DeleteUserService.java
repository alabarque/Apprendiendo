package com.proyecto.apprendiendo.services.UserService;

import com.proyecto.apprendiendo.repositories.ProjectRepository;
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
