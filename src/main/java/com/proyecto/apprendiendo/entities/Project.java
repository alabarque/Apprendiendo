package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long methodologyId;
    private Long challengeId;
    private Long classroomId;
    private String name;
}
