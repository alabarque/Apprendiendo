package com.proyecto.apprendiendo.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Classroom {
    private Long id;
    private String name;
    private Long teacherId;
    private String teacherName;
}