package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.repositories.AvatarBodyPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAvatarBodyPartService {

    private AvatarBodyPartRepository avatarBodyPartRepository;

    public void execute(AvatarBodyPartDTO avatarBodyPartDTO){
        AvatarBodyPart avatarBodyPart = avatarBodyPartRepository.getById(avatarBodyPartDTO.getId());
        avatarBodyPart.setId(avatarBodyPartDTO.getId());
        avatarBodyPart.setName(avatarBodyPartDTO.getName());
        avatarBodyPart.setPath(avatarBodyPartDTO.getPath());
        avatarBodyPart.setType(avatarBodyPartDTO.getType());
        avatarBodyPartRepository.save(avatarBodyPart);
    }
}
