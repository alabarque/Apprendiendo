package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.StoredTemplate;
import com.proyecto.apprendiendo.entities.TemplateReview;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import com.proyecto.apprendiendo.repositories.TemplateReviewRepository;
import com.proyecto.apprendiendo.services.mappers.StoredTemplateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class GetStoredTemplateService {

    private StoredTemplateRepository storedTemplateRepository;
    private TemplateReviewRepository templateReviewRepository;

    public StoredTemplateDTO execute(Long idClass) {
        StoredTemplate storedTemplate = storedTemplateRepository.getById(idClass);
        StoredTemplateDTO templateDTO = StoredTemplateMapper.entityToDto(storedTemplate);

        ArrayList<TemplateReview> reviews = templateReviewRepository.findByTemplateId(idClass);

        templateDTO.setReviewCount(reviews.size());

        if (reviews.size() > 0) templateDTO.setScore(reviews.stream().mapToDouble(r -> r.getScore()).average().getAsDouble());

        return  templateDTO;
    }
}
