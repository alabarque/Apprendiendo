package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.StoredTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StoredTemplateRepository extends JpaRepository<StoredTemplate, Long> {
    ArrayList<StoredTemplate> findByTemplateType(String templateType);
}
