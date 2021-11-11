package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="STUDENT_CLASSROOM")
@Table(name="STUDENT_CLASSROOM")
public class StudentClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private Long classroomId;
    private Integer grade;
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
}
