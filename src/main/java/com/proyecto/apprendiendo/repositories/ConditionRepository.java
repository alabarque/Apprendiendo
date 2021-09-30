package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {}
