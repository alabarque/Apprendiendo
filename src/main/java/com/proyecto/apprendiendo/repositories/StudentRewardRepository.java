package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.StudentReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRewardRepository extends JpaRepository<StudentReward, Long> {
    ArrayList<StudentReward> findByStudentIdAndRewardType(Long studentId, String rewardType);
}
