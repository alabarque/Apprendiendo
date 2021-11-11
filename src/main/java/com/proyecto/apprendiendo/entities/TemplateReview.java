package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TemplateReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long templateId;
    private Long reviewerId;
    private Integer score;
    private String review;
}
