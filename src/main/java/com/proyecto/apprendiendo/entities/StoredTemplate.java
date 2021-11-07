package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StoredTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String templateType;
    @Column(length = 10000000)
    private String template;
    private Long ownerId;
}
