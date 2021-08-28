package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.DocumentSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DocumentSourceRepository extends JpaRepository<DocumentSource,Long> {
    ArrayList<DocumentSource> findByDocumentId(Long documentId);
    ArrayList<DocumentSource> findBySourceId(Long sourceId);
    DocumentSource findByDocumentIdAndSourceId(Long documentId, Long sourceId);
    DocumentSource deleteBySourceIdAndDocumentId(Long sourceId, Long documentId);
}
