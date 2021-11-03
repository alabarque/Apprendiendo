package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StoredTemplateDTO {
    private Long id;
    private String name;
    private String description;
    private String templateType;
    private String template;
}
