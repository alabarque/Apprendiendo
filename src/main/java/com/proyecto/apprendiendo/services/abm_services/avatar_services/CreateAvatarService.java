package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAvatarService {

    private AvatarRepository avatarRepository;

    public void execute(AvatarDTO avatarDTO) {
        Avatar avatar = Avatar.builder().bodyId(avatarDTO.getBodyId()).headId(avatarDTO.getHeadId()).feetId(avatarDTO.getFeetId()).legsId(avatarDTO.getLegsId()).name(avatarDTO.getName()).build();
        avatarRepository.save(avatar);
    }
}
