package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.repositories.AvatarBodyPartRepository;
import com.proyecto.apprendiendo.services.mappers.AvatarBodyPartMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAvatarBodyPartService {

    private AvatarBodyPartRepository avatarBodyPartRepository;

    public AvatarBodyPartDTO execute(Long idClass) {
        AvatarBodyPart avatarBodyPart = avatarBodyPartRepository.getById(idClass);
        return AvatarBodyPartMapper.entityToDto(avatarBodyPart);
    }
}
