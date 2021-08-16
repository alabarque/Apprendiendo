package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AvatarBodyPartDTO {
    private Long id;
    private String name;
    private String type; //Enum BodypartType
    private String path;
}
