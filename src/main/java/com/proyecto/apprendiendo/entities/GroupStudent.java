package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="GROUP_STUDENT")
@Table(name="GROUP_STUDENT")
public class GroupStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId; //FK a User
    private Long groupId; //FK a Group
    private String groupRole;
}
