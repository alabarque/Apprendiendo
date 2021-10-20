package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteStoredTemplateService {

    private StoredTemplateRepository storedTemplateRepository;

    public Long execute(Long storedTemplateId) {
        storedTemplateRepository.deleteById(storedTemplateId);
        return storedTemplateId;
    }
}
