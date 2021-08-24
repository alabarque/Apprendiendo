package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;

public class AvatarBodyPartMapper {
    public static AvatarBodyPartDTO entityToDto(AvatarBodyPart avatarBodyPart){
        return AvatarBodyPartDTO.builder()
                                .id(avatarBodyPart.getId())
                                .path(avatarBodyPart.getPath())
                                .type(avatarBodyPart.getType())
                                .name(avatarBodyPart.getName())
                                .build();
    }
}
