package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="STUDENT_PROJECT")
@Table(name="STUDENT_PROJECT")
public class StudentProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private Long projectId;
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
    private Integer grade;
}
