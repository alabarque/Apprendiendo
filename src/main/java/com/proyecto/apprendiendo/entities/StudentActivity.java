package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="STUDENT_ACTIVITY")
@Table(name="STUDENT_ACTIVITY")
public class StudentActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private Long activityId;
    private Double percentageCompleted;
    private LocalDateTime dateCompleted;
    private Integer grade;
}
