package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
@AllArgsConstructor
@Transactional
public class UpdateDocumentService {

    private DocumentRepository documentRepository;

    public Long execute(DocumentDTO documentDTO) {
        Document document = documentRepository.getById(documentDTO.getId());
        document.setName(documentDTO.getName());
        document.setData(documentDTO.getData());
        document.setDataType(documentDTO.getDataType().toUpperCase(Locale.ROOT));
        document.setPosition(documentDTO.getPosition());
        documentRepository.save(document);
        return documentDTO.getId();
    }
}
