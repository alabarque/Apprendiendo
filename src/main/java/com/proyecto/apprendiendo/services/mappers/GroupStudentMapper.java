package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.GroupStudent;
import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;

public class GroupStudentMapper {
    public static GroupStudentDTO entityToDto(GroupStudent groupStudent) {
        return GroupStudentDTO.builder()
                              .id(groupStudent.getId())
                              .studentId(groupStudent.getStudentId())
                              .groupRole(groupStudent.getGroupRole())
                              .build();
    }
}
