package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TemplateReviewDTO {
    private Long id;
    private Long templateId;
    private StoredTemplateMetadataDTO template;
    private Long reviewerId;
    private UserDTO reviewer;
    private Integer score;
    private String review;
}
