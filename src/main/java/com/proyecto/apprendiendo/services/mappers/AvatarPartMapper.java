package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.AvatarPart;
import com.proyecto.apprendiendo.entities.dtos.AvatarPartDTO;

public class AvatarPartMapper {
    public static AvatarPartDTO entityToDto(AvatarPart avatarPart) {
        return AvatarPartDTO.builder()
                            .id(avatarPart.getId())
                            .imageData(avatarPart.getImageData())
                            .type(avatarPart.getType())
                            .name(avatarPart.getName())
                            .build();
    }
}
