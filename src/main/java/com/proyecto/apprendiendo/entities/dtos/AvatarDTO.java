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
    private String body; //FK a AvatarPart
    private String glasses; //FK a AvatarPart
    private String hat; //FK a AvatarPart
    private String clothes; //FK a AvatarPart
}
