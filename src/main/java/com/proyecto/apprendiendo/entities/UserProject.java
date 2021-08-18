package com.proyecto.apprendiendo.entities;

import jdk.jfr.Percentage;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserProject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long userId; //FK a User
    private Long projectId; //FK a Project
    private Boolean hasAchievement;
    private Double percentageCompleted; //Valor entre 0 y 1
}
