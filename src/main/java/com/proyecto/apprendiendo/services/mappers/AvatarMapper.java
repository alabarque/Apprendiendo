package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;

public class AvatarMapper {
    public static AvatarDTO entityToDto(Avatar avatar) {
        return AvatarDTO.builder()
                        .id(avatar.getId())
                        .name(avatar.getName())
                        .bodyId(avatar.getBodyId())
                        .glassesId(avatar.getGlassesId())
                        .hatId(avatar.getHatId())
                        .build();
    }
}
