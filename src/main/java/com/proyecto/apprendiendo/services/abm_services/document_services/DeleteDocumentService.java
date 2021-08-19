package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.repositories.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteDocumentService {

    private aaaa avatarRepository;

    public void execute(Long avatarId){
        avatarRepository.deleteById(avatarId);
    }
}
