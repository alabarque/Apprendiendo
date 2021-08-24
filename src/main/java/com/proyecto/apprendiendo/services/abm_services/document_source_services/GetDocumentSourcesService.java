package com.proyecto.apprendiendo.services.abm_services.document_source_services;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.SourceDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.DocumentSourceRepository;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.services.mappers.SourceMapper;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetDocumentSourcesService {

    private DocumentSourceRepository documentSourceRepository;

    public ArrayList<SourceDTO> execute(Long documentId) {
        ArrayList<DocumentSource> sourceDocuments = documentSourceRepository.findByDocumentId(documentId);
        return sourceDocuments.stream().map(sd -> SourceMapper.entityToDto(sd)).collect(Collectors.toCollection(ArrayList::new));
    }
}
