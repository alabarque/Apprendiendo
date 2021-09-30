package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateDocumentService {

    private DocumentRepository documentRepository;

    public Long execute(NewDocumentDTO newDocumentDTO) {
        Document document = Document.builder()
                                    .position(newDocumentDTO.getPosition())
                                    .sourceId(newDocumentDTO.getSourceId())
                                    .documentSourceType(newDocumentDTO.getDocumentSourceType())
                                    .data(newDocumentDTO.getData())
                                    .name(newDocumentDTO.getName())
                                    .dataType(newDocumentDTO.getDataType())
                                    .build();
        return documentRepository.save(document).getId();
    }
}
