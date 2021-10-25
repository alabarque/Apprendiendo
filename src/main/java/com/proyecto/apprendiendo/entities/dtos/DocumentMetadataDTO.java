package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DocumentMetadataDTO {
    private Long id;
    private Integer position;
    private String name;
    private String dataType;
    private Long sourceId;
    private String documentSourceType;
}
