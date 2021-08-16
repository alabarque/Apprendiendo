package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAvatarService {

    private AvatarRepository avatarRepository;

    public void execute(AvatarDTO avatarDTO){
        Avatar avatar = avatarRepository.getById(avatarDTO.getId());
        avatar.setId(avatarDTO.getId());
        avatar.setName(avatarDTO.getName());
        avatar.setBodyId(avatarDTO.getBodyId());
        avatar.setFeetId(avatarDTO.getFeetId());
        avatar.setHeadId(avatarDTO.getHeadId());
        avatar.setLegsId(avatarDTO.getLegsId());
        avatarRepository.save(avatar);
    }
}
