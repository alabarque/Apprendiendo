package com.proyecto.apprendiendo.entities;

import lombok.*;

@Getter
@Setter
@Builder
public class Classroom {
    private Long id;
    private String name;
    private Long teacherId;
    private String teacherName;
}
