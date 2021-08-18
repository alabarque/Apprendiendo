package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject,Long> {
    ArrayList<UserProject> findByUserId(Long userId);
    ArrayList<UserProject> findByProjectId(Long projectId);
    UserProject findByUserIdAndProjectId(Long userId, Long projectId);
    ArrayList<UserProject> deleteByProjectIdAndUserId(Long projectId, Long userId);

}
