package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
}
