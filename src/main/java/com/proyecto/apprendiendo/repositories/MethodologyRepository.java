package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Methodology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodologyRepository extends JpaRepository<Methodology, Long> {
}
