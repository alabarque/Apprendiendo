package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DocumentSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long documentId; //FK a Document
    private Long sourceID; //FK a Source
    private String documentSourceType; //Enum DocumentSourceType
}
