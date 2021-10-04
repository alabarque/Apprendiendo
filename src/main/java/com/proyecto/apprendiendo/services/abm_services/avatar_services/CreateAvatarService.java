package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateAvatarService {

    private AvatarRepository avatarRepository;

    public Long execute(AvatarDTO avatarDTO) {
        Avatar avatar = Avatar.builder()
                              .body(avatarDTO.getBody())
                              .hat(avatarDTO.getHat())
                              .glasses(avatarDTO.getGlasses())
                              .clothes(avatarDTO.getClothes())
                              .name(avatarDTO.getName())
                              .build();
        return avatarRepository.save(avatar).getId();
    }
}
