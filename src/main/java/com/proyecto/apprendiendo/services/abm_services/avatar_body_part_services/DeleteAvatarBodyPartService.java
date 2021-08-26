package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.repositories.AvatarBodyPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteAvatarBodyPartService {

    private AvatarBodyPartRepository avatarBodyPartRepository;

    public Long execute(Long avatarBodyPartId){
        avatarBodyPartRepository.deleteById(avatarBodyPartId);
        return avatarBodyPartId;
    }
}
