package com.proyecto.apprendiendo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sourceId; //FK a Source
    private String documentSourceType; //Enum DocumentSourceType
    private Integer position;
    private String name;
    private String dataType;
}

