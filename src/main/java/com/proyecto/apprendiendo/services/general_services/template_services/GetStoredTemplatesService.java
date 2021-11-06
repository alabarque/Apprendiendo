package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.TemplateReview;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;
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
public class GetStoredTemplatesService {

    private StoredTemplateRepository storedTemplateRepository;
    private TemplateReviewRepository templateReviewRepository;

    public ArrayList<StoredTemplateMetadataDTO> execute(String templateType) {
        return storedTemplateRepository.findByTemplateType(templateType)
                                       .stream()
                                       .map(storedTemplate -> {
                                           StoredTemplateMetadataDTO templateDTO = StoredTemplateMapper.entityToMetaDto(storedTemplate);
                                           ArrayList<TemplateReview> reviews = templateReviewRepository.findByTemplateId(storedTemplate.getId());
                                           templateDTO.setReviewCount(reviews.size());
                                           if (reviews.size() > 0) templateDTO.setScore(reviews.stream().mapToDouble(r -> r.getScore()).average().getAsDouble());
                                           return  templateDTO;
                                       })
                                       .collect(Collectors.toCollection(ArrayList::new));
    }
}
