package com.proyecto.apprendiendo.services.abm_services.document_source_services;

import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.enums.DocumentSourceType;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddDocumentToSourceService {

    private DocumentSourceRepository documentSourceRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long documentId, Long sourceId, String documentSourceType){
        documentSourceRepository.save(DocumentSource.builder().sourceId(sourceId).documentId(documentId).documentSourceType(documentSourceType).build());
        return sourceId;
    }
}
