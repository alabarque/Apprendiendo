package com.proyecto.apprendiendo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Entity(name = "DOCUMENT_SUMMARY")
@Table(name = "DOCUMENT")
public class DocumentSummary extends BaseDocument {}
