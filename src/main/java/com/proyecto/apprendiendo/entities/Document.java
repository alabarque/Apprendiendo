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
    private Long sourceId; //FK a Source
    private String documentSourceType; //Enum DocumentSourceType
    private Integer position;
    private String name;
    private String dataType;
    @Column(length = 100000000)
    private String data;
}
