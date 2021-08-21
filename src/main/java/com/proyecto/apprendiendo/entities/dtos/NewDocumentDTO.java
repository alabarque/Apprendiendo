package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewDocumentDTO {
    private Long id;
    private String name;
    private Long ownerId; //FK a User
    private String dataType;
    private String data;
    private Long sourceId; //FK a una implementacion de Source
    private String documentSourceType; //ENUM DocumentSourceType
}
