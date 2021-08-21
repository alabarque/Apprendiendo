package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Long userId; //FK a User
    private Long headId; //FK a AvatarBodypart
    private Long bodyId; //FK a AvatarBodypart
    private Long legsId; //FK a AvatarBodypart
    private Long feetId; //FK a AvatarBodypart
}
