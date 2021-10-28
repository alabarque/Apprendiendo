package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GroupStudentDTO {
    private Long id;
    private Long studentId;
    private StudentDTO student; //FK a User
    private Long groupId;
    private GroupDTO group; //FK a Group
    private String groupRole;
}
