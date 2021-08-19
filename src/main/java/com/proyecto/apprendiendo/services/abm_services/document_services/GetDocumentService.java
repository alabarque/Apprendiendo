package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
import com.proyecto.apprendiendo.services.mappers.AvatarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetDocumentService {

    private aaaa avatarRepository;

    public AvatarDTO execute(Long idClass) {
        Avatar avatar = avatarRepository.getById(idClass);
        return AvatarMapper.entityToDto(avatar);
    }
}
