package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long ownerId; //FK a User
    private String dataType;
    @Column(length=1000000)
    private String data;
}
