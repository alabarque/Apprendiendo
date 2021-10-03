package com.proyecto.apprendiendo.services.abm_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetSourcesDocumentsService {

    private DocumentRepository documentRepository;

    public ArrayList<DocumentDTO> execute(Long sourceId) {
        ArrayList<Document> documents = documentRepository.findBySourceId(sourceId);
        return documents.stream()
                        .map(document -> DocumentMapper.entityToDto(documentRepository.getById(document.getId())))
                        .collect(Collectors.toCollection(ArrayList::new));
    }
}
