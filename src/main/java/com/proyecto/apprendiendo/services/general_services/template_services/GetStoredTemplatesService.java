package com.proyecto.apprendiendo.services.general_services.template_services;

import com.proyecto.apprendiendo.entities.dtos.StoredTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.StoredTemplateMetadataDTO;
import com.proyecto.apprendiendo.repositories.StoredTemplateRepository;
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

    public ArrayList<StoredTemplateMetadataDTO> execute(String templateType) {
        return storedTemplateRepository.findByTemplateType(templateType)
                                       .stream()
                                       .map(storedTemplate -> StoredTemplateMapper.entityToMetaDto(storedTemplate))
                                       .collect(Collectors.toCollection(ArrayList::new));
    }
}
