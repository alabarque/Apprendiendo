package com.proyecto.apprendiendo.services.abm_services.document_source_services;

import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import com.proyecto.apprendiendo.services.abm_services.document_services.DeleteDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveSourcesDocumentsService {

    private DeleteDocumentService deleteDocumentService;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long sourceId, ArrayList<DocumentDTO> documentDTOs){
        documentDTOs.forEach(d -> deleteDocumentService.execute(d.getId(),sourceId));
    }
}
