package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.repositories.AvatarBodyPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAvatarBodyPartService {

    private AvatarBodyPartRepository avatarBodyPartRepository;

    public void execute(Long avatarBodyPartId){
        avatarBodyPartRepository.deleteById(avatarBodyPartId);
    }
}
