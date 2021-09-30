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
public class CreateAvatarPartService {

    private AvatarPartRepository avatarPartRepository;

    public Long execute(AvatarPartDTO avatarPartDTO) {
        AvatarPart avatarPart = AvatarPart.builder()
                                          .name(avatarPartDTO.getName())
                                          .imageData(avatarPartDTO.getImageData())
                                          .type(avatarPartDTO.getType())
                                          .build();
        return avatarPartRepository.save(avatarPart).getId();
    }
}
