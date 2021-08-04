package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
