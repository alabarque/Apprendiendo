package com.proyecto.apprendiendo.services.abm_services.avatar_part_services;

import com.proyecto.apprendiendo.entities.AvatarPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarPartDTO;
import com.proyecto.apprendiendo.repositories.AvatarPartRepository;
import com.proyecto.apprendiendo.services.mappers.AvatarPartMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetAvatarPartService {

    private AvatarPartRepository avatarPartRepository;

    public AvatarPartDTO execute(Long idClass) {
        AvatarPart avatarPart = avatarPartRepository.getById(idClass);
        return AvatarPartMapper.entityToDto(avatarPart);
    }
}
