package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    ArrayList<Project> findByClassroomId(Long classroomId);
}
