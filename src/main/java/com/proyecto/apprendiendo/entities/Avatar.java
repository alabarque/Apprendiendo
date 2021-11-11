package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="AVATAR")
@Table(name="AVATAR")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String body;      //FK a AvatarPart
    private String glasses;   //FK a AvatarPart
    private String hat;       //FK a AvatarPart
    private String clothes;   //FK a AvatarPart
}
