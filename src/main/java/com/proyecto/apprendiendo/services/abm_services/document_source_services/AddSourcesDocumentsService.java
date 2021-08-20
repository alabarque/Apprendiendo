package com.proyecto.apprendiendo.services.abm_services.document_source_services;

import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddSourcesDocumentsService {

    private DocumentSourceRepository documentSourceRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long sourceId, ArrayList<DocumentDTO> documentDTOs){
        documentDTOs.forEach(s -> documentSourceRepository.save(DocumentSource.builder().sourceId(sourceId).documentId(s.getId()).build()));
    }
}
