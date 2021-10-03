package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GroupStudentDTO {
    private Long id;
    private Long studentId; //FK a User
    private Long groupId; //FK a Group
    private String groupRole;
}
