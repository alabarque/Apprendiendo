package com.proyecto.apprendiendo.services.general_services.user_services;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.dtos.UserDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateUserService {

    private UserRepository userRepository;

    public Long execute(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());

        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setAvatarId(userDTO.getAvatarId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setHomePhone(userDTO.getHomePhone());
        user.setMobilePhone(userDTO.getMobilePhone());
        user.setImageData(user.getImageData());
        user.setStudentDivision(user.getStudentDivision());
        user.setStudentYear(user.getStudentYear());

        userRepository.save(user);
        return userDTO.getId();
    }
}
