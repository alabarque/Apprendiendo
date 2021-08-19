package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.enums.DocumentSourceType;
import com.proyecto.apprendiendo.repositories.AvatarRepository;
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

    public Long execute(DocumentDTO documentDTO, DocumentSourceType documentSourceType, Long sourceId) {
        Document document = Document.builder().data(documentDTO.getData()).name(documentDTO.getName()).dataType(documentDTO.getDataType()).ownerId(documentDTO.getOwnerId()).build();
        Long documentId = documentRepository.save(document).getId();
        DocumentSource documentSource = DocumentSource.builder().sourceID(sourceId).documentSourceType(documentSourceType.getValue()).documentId(documentId).build();
        documentSourceRepository.save(documentSource);
        return documentId;
    }
}
