package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateDocumentService {

    private DocumentRepository documentRepository;

    public Long execute(DocumentDTO documentDTO) {
        Document document = documentRepository.getById(documentDTO.getId());
        document.setName(documentDTO.getName());
        document.setData(documentDTO.getData());
        document.setDataType(documentDTO.getDataType());
        document.setPosition(documentDTO.getPosition());
        documentRepository.save(document);
        return documentDTO.getId();
    }
}
