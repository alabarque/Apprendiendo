package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateDocumentService {

    private aaaa avatarRepository;

    public void execute(AvatarDTO avatarDTO){
        Avatar avatar = avatarRepository.getById(avatarDTO.getId());
        avatar.setId(avatarDTO.getId());
        avatar.setUserId(avatarDTO.getUserId());
        avatar.setName(avatarDTO.getName());
        avatar.setBodyId(avatarDTO.getBodyId());
        avatar.setFeetId(avatarDTO.getFeetId());
        avatar.setHeadId(avatarDTO.getHeadId());
        avatar.setLegsId(avatarDTO.getLegsId());
        avatarRepository.save(avatar);
    }
}
