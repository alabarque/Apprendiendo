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
public class CreateStoredTemplateService {

    private StoredTemplateRepository storedTemplateRepository;

    public Long execute(StoredTemplateDTO storedTemplateDTO) {
        StoredTemplate storedTemplate = StoredTemplate.builder()
                                                      .name(storedTemplateDTO.getName())
                                                      .template(storedTemplateDTO.getTemplate())
                                                      .description(storedTemplateDTO.getDescription())
                                                      .templateType(storedTemplateDTO.getTemplateType())
                                                      .build();
        return storedTemplateRepository.save(storedTemplate).getId();
    }
}
