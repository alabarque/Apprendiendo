package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentProjectRepository extends JpaRepository<StudentProject,Long> {
    ArrayList<StudentProject> findByUserId(Long userId);
    ArrayList<StudentProject> findByProjectId(Long projectId);
    StudentProject findByUserIdAndProjectId(Long userId, Long projectId);
    ArrayList<StudentProject> deleteByProjectIdAndUserId(Long projectId, Long userId);

}
