package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;

public class StoredTemplateMapper {
    public static StoredTemplateDTO entityToDto(StoredTemplate storedTemplate) {
        return StoredTemplateDTO.builder()
                                .id(storedTemplate.getId())
                                .name(storedTemplate.getName())
                                .description(storedTemplate.getDescription())
                                .template(storedTemplate.getTemplate())
                                .templateType(storedTemplate.getTemplateType())
                                .ownerId(storedTemplate.getOwnerId())
                                .build();
    }

    public static StoredTemplateMetadataDTO entityToMetaDto(StoredTemplate storedTemplate) {
        return StoredTemplateMetadataDTO.builder()
                                        .id(storedTemplate.getId())
                                        .name(storedTemplate.getName())
                                        .description(storedTemplate.getDescription())
                                        .templateType(storedTemplate.getTemplateType())
                                        .ownerId(storedTemplate.getOwnerId())
                                        .build();
    }
}
