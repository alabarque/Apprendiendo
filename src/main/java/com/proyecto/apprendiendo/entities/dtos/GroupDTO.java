package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class GroupDTO {
    protected Long id;
    protected Long projectId; //FK a Project
    protected ProjectDTO project;
    protected Double progress;
    protected String name;
    protected ArrayList<GroupStudentDTO> members;
}
