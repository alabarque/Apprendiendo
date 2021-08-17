package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.repositories.AvatarBodyPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateAvatarBodyPartService {

    private AvatarBodyPartRepository avatarBodyPartRepository;

    public Long execute(AvatarBodyPartDTO avatarBodyPartDTO) {
        AvatarBodyPart avatarBodyPart = AvatarBodyPart.builder().name(avatarBodyPartDTO.getName()).path(avatarBodyPartDTO.getPath()).type(avatarBodyPartDTO.getType()).build();
        return avatarBodyPartRepository.save(avatarBodyPart).getId();
    }
}
