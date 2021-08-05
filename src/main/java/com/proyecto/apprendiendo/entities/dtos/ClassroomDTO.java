package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClassroomDTO {
    private Long id;
    private String name;
    private Long teacherId;
    private String teacherName;
}
