package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSourceRepository extends JpaRepository<DocumentSource,Long> {
}
