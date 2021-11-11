package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="LESSON")
@Table(name="LESSON")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer position;
    private String name;
    private String description;
    private Long projectId; //FK a Project
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private Boolean active;
}
