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
    private Long bodyId; //FK a AvatarPartType
    private Long glassesId; //FK a AvatarPartType
    private Long hatId; //FK a AvatarPartType
}
