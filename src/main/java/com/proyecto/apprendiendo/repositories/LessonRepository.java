package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    ArrayList<Lesson> findByProjectId(Long projectId);
}
