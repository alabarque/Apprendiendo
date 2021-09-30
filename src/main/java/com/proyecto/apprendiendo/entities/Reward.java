package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; //nombre de la recompenza, ej "Insignia del Campeon"
    private Long conditionId; //FK a Condition
    private String rewardType; //ENUM RewardType
    @Column(length = 1000000)
    private String text; //descripcion de la recompenza de existir. Importante que exista para rewardType SOCIAL.
    private Long targetId; //FK a Classroom, Project o Activity, dependiendo de targetType. Donde esta disponible, tambien es el target de la condition.
    private String targetType; //ENUM TargetType
    @Column(length = 1000000)
    private String imageData; //imagen de existir, importante para los rewardType BADGE, CHALLENGE, ACHIEVEMENT
}
