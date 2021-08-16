package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AvatarDTO {
    private Long id;
    private String type;
    private String path;
    private Long headId; //FK a AvatarBodypart
    private Long bodyId; //FK a AvatarBodypart
    private Long legsId; //FK a AvatarBodypart
    private Long feetId; //FK a AvatarBodypart

}
