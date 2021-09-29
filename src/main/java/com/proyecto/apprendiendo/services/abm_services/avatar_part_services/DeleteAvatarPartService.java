package com.proyecto.apprendiendo.services.abm_services.avatar_part_services;

import com.proyecto.apprendiendo.repositories.AvatarPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteAvatarPartService {

    private AvatarPartRepository avatarPartRepository;

    public Long execute(Long avatarPartId){
        avatarPartRepository.deleteById(avatarPartId);
        return avatarPartId;
    }
}
