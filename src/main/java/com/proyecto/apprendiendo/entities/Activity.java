package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="ACTIVITY")
@Table(name="ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer position;
    private String name;
    private String description;
    private Long lessonId; //FK a Lesson
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
}
