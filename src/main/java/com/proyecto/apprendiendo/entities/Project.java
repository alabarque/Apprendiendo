package com.proyecto.apprendiendo.entities;

import com.proyecto.apprendiendo.entities.interfaces.Source;
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
public class Project implements Source {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long methodologyId; //FK a Methodology
    private Long challengeId; //FK a Challenge
    private Long classroomId; //FK a Classroom
    private String name;
}
