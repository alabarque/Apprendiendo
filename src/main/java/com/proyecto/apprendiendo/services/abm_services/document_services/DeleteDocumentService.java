package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.repositories.AvatarRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteDocumentService {

    private DocumentRepository documentRepository;
    private DocumentSourceRepository documentSourceRepository;

    public void execute(Long documentId, Long sourceId){
        documentSourceRepository.deleteBySourceIdAndDocumentId(sourceId, documentId);
        if (documentSourceRepository.findByDocumentId(documentId).size() == 0) documentRepository.deleteById(documentId);
    }
}
