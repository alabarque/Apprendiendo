package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.DocumentSummary;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.DocumentSummaryRepository;
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
    private DocumentSummaryRepository documentSummaryRepository;



    public ArrayList<DocumentDTO> execute(Long sourceId) {
        ArrayList<Document> documents = documentRepository.findBySourceId(sourceId);
        return documents.stream()
                        .map(document -> DocumentMapper.entityToDto(document))
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<DocumentDTO> execute(Long sourceId, String mode) {
        if (mode.equals("FULL")) return execute(sourceId);
        if (mode.equals("SELECTIVE")) return getSourcesDocumentsSelective(sourceId);
        if (mode.equals("SUMMARY")) return getSourcesDocumentsSummary(sourceId);
        return null;
    }

    private ArrayList<DocumentDTO> getSourcesDocumentsSelective(Long sourceId) {
        ArrayList<DocumentSummary> documentsMeta = documentSummaryRepository.findBySourceId(sourceId);
        return documentsMeta.stream()
                            .map(documentMeta -> {
                                if (documentMeta.getDataType().equals("FILE")) return DocumentMapper.entitySummaryToDto(documentMeta);
                                else return DocumentMapper.entityToDto(documentRepository.getById(documentMeta.getId()));
                            })
                            .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<DocumentDTO> getSourcesDocumentsSummary(Long sourceId) {
        ArrayList<DocumentSummary> documents = documentSummaryRepository.findBySourceId(sourceId);
        return documents.stream()
                        .map(document -> DocumentMapper.entitySummaryToDto(document))
                        .collect(Collectors.toCollection(ArrayList::new));
    }
}
