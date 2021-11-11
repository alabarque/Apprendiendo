package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="PROJECT")
@Table(name="PROJECT")
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
