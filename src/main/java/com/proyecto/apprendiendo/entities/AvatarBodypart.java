package com.proyecto.apprendiendo.entities;

import com.proyecto.apprendiendo.entities.enums.BodyPartType;
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
public class AvatarBodypart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private BodyPartType type;
    private String path;

}
