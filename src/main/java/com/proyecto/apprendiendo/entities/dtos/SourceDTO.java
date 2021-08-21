package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SourceDTO {
    private Long id;
    private String documentSourceType; //Enum DocumentSourceType
}
