package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateDocumentService {

    private DocumentRepository documentRepository;

    public Long execute(DocumentDTO documentDTO) {
        Document document = Document.builder()
                                    .position(documentDTO.getPosition())
                                    .sourceId(documentDTO.getSourceId())
                                    .documentSourceType(documentDTO.getDocumentSourceType())
                                    .data(documentDTO.getData())
                                    .name(documentDTO.getName())
                                    .dataType(documentDTO.getDataType())
                                    .build();
        return documentRepository.save(document).getId();
    }
}
