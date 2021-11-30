package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.StudentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivity, Long> {
    ArrayList<StudentActivity> findByStudentId(Long studentId);

    ArrayList<StudentActivity> findByActivityId(Long activityId);

    ArrayList<StudentActivity> findByStudentIdAndPercentageCompleted(Long studentId, Double percentageCompleted);

    StudentActivity findByStudentIdAndActivityId(Long studentId, Long activityId);

    Integer deleteByActivityIdAndStudentId(Long activityId, Long studentId);
}
