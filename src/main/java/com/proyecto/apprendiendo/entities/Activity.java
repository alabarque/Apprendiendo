package com.proyecto.apprendiendo.entities;

import com.proyecto.apprendiendo.entities.interfaces.Source;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Activity implements Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long challengeId; //FK a Challenge
    private Long projectId; //FK a Project
    private LocalDate startDate;
    private LocalDate dueDate;
}
