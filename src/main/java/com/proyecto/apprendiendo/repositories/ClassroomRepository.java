package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    ArrayList<Classroom> findByTeacherId(Long teacherId);
}
