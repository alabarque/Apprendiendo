package com.proyecto.apprendiendo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name="DOCUMENT")
@Table(name = "DOCUMENT")
public class Document extends BaseDocument{
    @Column(length = 100000000)
    private String data;
}
