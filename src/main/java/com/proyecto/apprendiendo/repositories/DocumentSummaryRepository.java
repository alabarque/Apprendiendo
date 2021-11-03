package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.DocumentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DocumentSummaryRepository extends JpaRepository<DocumentSummary, Long> {
    ArrayList<DocumentSummary> findBySourceId(Long sourceId);
}
