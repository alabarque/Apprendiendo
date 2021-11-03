package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer position;
    private Long methodologyId; //FK a Methodology
    private Long classroomId; //FK a Classroom
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private String name;
    private String description;
    private Boolean active;
}
