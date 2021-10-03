package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;

public class GroupMapper {
    public static GroupDTO entityToDto(Group group) {
        return GroupDTO.builder()
                       .id(group.getId())
                       .name(group.getName())
                       .projectId(group.getProjectId())
                       .build();
    }
}
