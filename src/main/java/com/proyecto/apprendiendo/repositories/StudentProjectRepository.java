package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentProjectRepository extends JpaRepository<StudentProject, Long> {
    ArrayList<StudentProject> findByStudentId(Long studentId);

    ArrayList<StudentProject> findByStudentIdAndPercentageCompleted(Long studentId, Double percentageCompleted);

    ArrayList<StudentProject> findByProjectId(Long projectId);

    StudentProject findByStudentIdAndProjectId(Long studentId, Long projectId);

    StudentProject deleteByProjectIdAndStudentId(Long projectId, Long studentId);


}
