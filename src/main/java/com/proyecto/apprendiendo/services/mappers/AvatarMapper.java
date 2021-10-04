package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;

public class AvatarMapper {
    public static AvatarDTO entityToDto(Avatar avatar) {
        return AvatarDTO.builder()
                        .id(avatar.getId())
                        .name(avatar.getName())
                        .body(avatar.getBody())
                        .glasses(avatar.getGlasses())
                        .hat(avatar.getHat())
                        .clothes(avatar.getClothes())
                        .build();
    }
}
