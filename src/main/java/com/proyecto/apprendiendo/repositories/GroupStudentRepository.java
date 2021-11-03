package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.GroupStudent;
import com.proyecto.apprendiendo.entities.StudentReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GroupStudentRepository extends JpaRepository<GroupStudent, Long> {
    ArrayList<GroupStudent> findByStudentIdAndGroupRole(Long studentId, String groupRole);

    GroupStudent findByStudentIdAndGroupId(Long studentId, Long groupId);

    ArrayList<GroupStudent> findByStudentId(Long studentId);

    ArrayList<GroupStudent> findByGroupId(Long studentId);

    GroupStudent deleteByStudentIdAndGroupId(Long studentId, Long groupId);
}
