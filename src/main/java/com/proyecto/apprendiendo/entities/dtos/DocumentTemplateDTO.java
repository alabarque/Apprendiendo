package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DocumentTemplateDTO {
    private String name;
    private Integer position;
    private String dataType;
    private String data;
}
