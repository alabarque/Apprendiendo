package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.TemplateReview;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;
import com.proyecto.apprendiendo.entities.dtos.TemplateReviewDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import com.proyecto.apprendiendo.repositories.TemplateReviewRepository;
import com.proyecto.apprendiendo.services.mappers.StoredTemplateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class AddTemplateReviewService {

    private TemplateReviewRepository templateReviewRepository;

    public Long execute(TemplateReviewDTO templateReviewDTO) {
        TemplateReview templateReview = TemplateReview.builder()
                                                      .review(templateReviewDTO.getReview())
                                                      .reviewerId(templateReviewDTO.getReviewerId())
                                                      .templateId(templateReviewDTO.getTemplateId())
                                                      .score(Math.min(Math.max(templateReviewDTO.getScore(), 0), 5))
                                                      .build();

        TemplateReview existingReview = templateReviewRepository.findByReviewerIdAndTemplateId(templateReviewDTO.getReviewerId(), templateReviewDTO.getTemplateId());

        if (existingReview != null) templateReviewRepository.delete(existingReview);

        return templateReviewRepository.save(templateReview).getId();
    }
}
