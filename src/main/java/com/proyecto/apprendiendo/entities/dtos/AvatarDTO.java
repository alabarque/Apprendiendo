package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AvatarDTO {
    private Long id;
    private String name;
    private Long bodyId; //FK a AvatarPart
    private Long glassesId; //FK a AvatarPart
    private Long hatId; //FK a AvatarPart
    private Long clothesId; //FK a AvatarPart
}
