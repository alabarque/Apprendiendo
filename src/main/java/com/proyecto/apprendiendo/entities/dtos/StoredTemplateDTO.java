package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class StoredTemplateDTO {
    private Long id;
    private String name;
    private String description;
    private String templateType;
    private String template;
    private Long ownerId;
    private UserDTO owner;
    private Double score;
    private Integer reviewCount;
    private Long methodologyId;
    private MethodologyDTO methodology;
    private ArrayList<TemplateReviewDTO> reviews;
}
