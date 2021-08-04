package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    private Long id;
    private Long methodologyId;
    private Long challengeId;
    private Long classroomId;
    private String name;
}
