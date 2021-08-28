package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.UserClassroom;
import com.proyecto.apprendiendo.entities.UserClassroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserClassroomRepository extends JpaRepository<UserClassroom,Long> {
    ArrayList<UserClassroom> findByUserId(Long userId);
    ArrayList<UserClassroom> findByClassroomId(Long classroomId);
    UserClassroom findByUserIdAndClassroomId(Long userId, Long classroomId);
    UserClassroom deleteByClassroomIdAndUserId(Long classroomId, Long userId);
}
