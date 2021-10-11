package com.proyecto.apprendiendo.services.general_services.avatar_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateAvatarService {

    private AvatarRepository avatarRepository;

    public Long execute(AvatarDTO avatarDTO) {
        Avatar avatar = avatarRepository.getById(avatarDTO.getId());
        avatar.setName(avatarDTO.getName());
        avatar.setBody(avatarDTO.getBody());
        avatar.setGlasses(avatarDTO.getGlasses());
        avatar.setHat(avatarDTO.getHat());
        avatar.setClothes(avatarDTO.getClothes());
        avatarRepository.save(avatar);
        return avatarDTO.getId();
    }
}
