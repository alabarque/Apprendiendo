package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.entities.enums.DocumentSourceType;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateDocumentService {

    private DocumentRepository documentRepository;
    private DocumentSourceRepository documentSourceRepository;

    public Long execute(NewDocumentDTO newDocumentDTO) {
        Document document = Document.builder().position(newDocumentDTO.getPosition()).data(newDocumentDTO.getData()).name(newDocumentDTO.getName()).dataType(newDocumentDTO.getDataType()).build();
        Long documentId = documentRepository.save(document).getId();
        DocumentSource documentSource = DocumentSource.builder().sourceId(newDocumentDTO.getSourceId()).documentSourceType(newDocumentDTO.getDocumentSourceType()).documentId(documentId).build();
        documentSourceRepository.save(documentSource);
        return documentId;
    }
}
