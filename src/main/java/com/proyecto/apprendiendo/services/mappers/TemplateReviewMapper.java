package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.TemplateReview;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;
import com.proyecto.apprendiendo.entities.dtos.TemplateReviewDTO;

public class TemplateReviewMapper {
    public static TemplateReviewDTO entityToDto(TemplateReview templateReview) {
        return TemplateReviewDTO.builder()
                                .id(templateReview.getId())
                                .review(templateReview.getReview())
                                .templateId(templateReview.getTemplateId())
                                .reviewerId(templateReview.getReviewerId())
                                .score(templateReview.getScore())
                                .build();
    }

}
