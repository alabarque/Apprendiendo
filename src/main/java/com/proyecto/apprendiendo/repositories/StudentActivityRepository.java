package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.StudentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivity,Long> {
    ArrayList<StudentActivity> findByUserId(Long userId);
    ArrayList<StudentActivity> findByActivityId(Long activityId);
    StudentActivity findByUserIdAndActivityId(Long userId, Long activityId);
    StudentActivity deleteByActivityIdAndUserId(Long activityId, Long userId);
}
