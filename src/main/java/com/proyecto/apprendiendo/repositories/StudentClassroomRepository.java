package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentClassroomRepository extends JpaRepository<StudentClassroom,Long> {
    ArrayList<StudentClassroom> findByStudentId(Long studentId);
    ArrayList<StudentClassroom> findByClassroomId(Long classroomId);
    ArrayList<StudentClassroom> findByStudentIdAndPercentageCompleted(Long studentId, Double percentageCompleted);
    StudentClassroom findByStudentIdAndClassroomId(Long studentId, Long classroomId);
    StudentClassroom deleteByClassroomIdAndStudentId(Long classroomId, Long studentId);
}
