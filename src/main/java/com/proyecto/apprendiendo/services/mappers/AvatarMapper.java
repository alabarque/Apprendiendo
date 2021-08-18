package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;

public class AvatarMapper {
    public static AvatarDTO entityToDto(Avatar avatar){
        return AvatarDTO.builder().id(avatar.getId()).name(avatar.getName()).bodyId(avatar.getBodyId()).feetId(avatar.getFeetId()).headId(avatar.getHeadId()).legsId(avatar.getLegsId()).userId(avatar.getUserId()).build();
    }
}
