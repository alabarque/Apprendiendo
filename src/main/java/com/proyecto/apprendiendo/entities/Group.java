package com.proyecto.apprendiendo.entities;

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
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Long projectId; //FK a Project
    protected String name;
}
