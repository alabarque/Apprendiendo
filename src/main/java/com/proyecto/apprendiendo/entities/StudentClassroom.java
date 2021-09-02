package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentClassroom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long studentId; //FK a User
    private Long classroomId; //FK a Classroom
    private Integer grade;
    private Boolean completed;
    private LocalDate dateCompleted;
}
