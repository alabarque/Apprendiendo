package com.proyecto.apprendiendo.services.abm_services.document_source_services;

import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
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

    private DocumentSourceRepository documentSourceRepository;
    private DocumentRepository documentRepository;

    public ArrayList<DocumentDTO> execute(Long sourceId) {
        ArrayList<DocumentSource> sourceDocuments = documentSourceRepository.findBySourceId(sourceId);
        return sourceDocuments.stream().map(ps -> DocumentMapper.entityToDto(documentRepository.getById(ps.getDocumentId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
