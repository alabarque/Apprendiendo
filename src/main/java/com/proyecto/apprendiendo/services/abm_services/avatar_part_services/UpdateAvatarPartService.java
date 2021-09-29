package com.proyecto.apprendiendo.services.abm_services.avatar_part_services;

import com.proyecto.apprendiendo.entities.AvatarPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarPartDTO;
import com.proyecto.apprendiendo.repositories.AvatarPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateAvatarPartService {

    private AvatarPartRepository avatarPartRepository;

    public Long execute(AvatarPartDTO avatarPartDTO){
        AvatarPart avatarPart = avatarPartRepository.getById(avatarPartDTO.getId());
        avatarPart.setId(avatarPartDTO.getId());
        avatarPart.setName(avatarPartDTO.getName());
        avatarPart.setImageData(avatarPartDTO.getImageData());
        avatarPart.setType(avatarPartDTO.getType());
        avatarPartRepository.save(avatarPart);
        return avatarPartDTO.getId();
    }
}
