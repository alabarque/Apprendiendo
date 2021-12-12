package com.proyecto.apprendiendo.services.general_services.template_services;

import com.google.gson.Gson;
import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
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
                                                      .methodologyId(getMethodologyId(storedTemplateDTO))
                                                      .description(storedTemplateDTO.getDescription())
                                                      .templateType(storedTemplateDTO.getTemplateType())
                                                      .ownerId(storedTemplateDTO.getOwnerId())
                                                      .build();
        return storedTemplateRepository.save(storedTemplate).getId();
    }

    private Long getMethodologyId(StoredTemplateDTO storedTemplateDTO){
        if(storedTemplateDTO.getTemplateType().equals("PROJECT")){
            //ProjectTemplateDTO template = new Gson().fromJson(storedTemplateDTO.getTemplate(), ProjectTemplateDTO.class);
            return storedTemplateDTO.getMethodologyId();
        }
        return null;
    }
}
