package com.proyecto.apprendiendo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "DOCUMENT")
public class DocumentSummary extends BaseDocument {}
