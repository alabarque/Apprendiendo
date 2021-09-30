package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AvatarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type; //Enum AvatarPartType
    @Column(length = 1000000)
    private String imageData;
}

