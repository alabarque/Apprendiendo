package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;
import com.proyecto.apprendiendo.entities.dtos.TemplateReviewDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
import com.proyecto.apprendiendo.repositories.TemplateReviewRepository;
import com.proyecto.apprendiendo.services.mappers.StoredTemplateMapper;
import com.proyecto.apprendiendo.services.mappers.TemplateReviewMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetTemplateReviewsService {

    private TemplateReviewRepository templateReviewRepository;

    public ArrayList<TemplateReviewDTO> execute(Long templateId) {
        return templateReviewRepository.findByTemplateId(templateId)
                                       .stream()
                                       .map(review -> TemplateReviewMapper.entityToDto(review))
                                       .collect(Collectors.toCollection(ArrayList::new));
    }
}
