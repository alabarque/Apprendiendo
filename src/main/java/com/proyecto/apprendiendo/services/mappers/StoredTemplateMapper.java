package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;

public class StoredTemplateMapper {
    public static StoredTemplateDTO entityToDto(StoredTemplate storedTemplate) {
        return StoredTemplateDTO.builder()
                                .id(storedTemplate.getId())
                                .name(storedTemplate.getName())
                                .description(storedTemplate.getDescription())
                                .template(storedTemplate.getTemplate())
                                .templateType(storedTemplate.getTemplateType())
                                .build();
    }
}
