package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import com.proyecto.apprendiendo.services.mappers.StoredTemplateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStoredTemplateService {

    private StoredTemplateRepository storedTemplateRepository;

    public StoredTemplateDTO execute(Long idClass) {
        StoredTemplate storedTemplate = storedTemplateRepository.getById(idClass);
        return StoredTemplateMapper.entityToDto(storedTemplate);
    }
}
