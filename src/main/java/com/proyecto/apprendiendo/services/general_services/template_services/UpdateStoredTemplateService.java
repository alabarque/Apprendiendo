package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStoredTemplateService {

    private StoredTemplateRepository storedTemplateRepository;

    public Long execute(StoredTemplateDTO storedTemplateDTO) {
        StoredTemplate storedTemplate = storedTemplateRepository.getById(storedTemplateDTO.getId());
        storedTemplate.setName(storedTemplateDTO.getName());
        storedTemplate.setTemplateType(storedTemplateDTO.getTemplateType());
        storedTemplate.setTemplate(storedTemplateDTO.getName());
        storedTemplate.setDescription(storedTemplateDTO.getName());
        storedTemplateRepository.save(storedTemplate);
        return storedTemplateDTO.getId();
    }
}
