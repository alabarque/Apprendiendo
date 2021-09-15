package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Condition {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length=1000000)
    private String text; //descripcion, importante que exista para conditionType SOCIAL
    private String conditionType; //Enum ConditionType
    private String data; //Se usa junto al ConditionType para evaluar la Condition
}
