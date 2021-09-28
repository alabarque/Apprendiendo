package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteDocumentService {

    private DocumentRepository documentRepository;

    public Long execute(Long documentId, Long sourceId){
        documentRepository.deleteById(documentId);
        return documentId;
    }
}
