package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@Entity
public class Classroom {
    @Id
    private Long id;
    private String name;
    private Long teacherId;
    private String teacherName;
}
