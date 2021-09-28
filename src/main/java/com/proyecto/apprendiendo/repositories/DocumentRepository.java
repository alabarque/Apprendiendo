package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
    ArrayList<Document> findBySourceId(Long sourceId);
}
