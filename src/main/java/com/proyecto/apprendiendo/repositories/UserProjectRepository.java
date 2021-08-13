package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject,Long> {
    ArrayList<UserProject> findallByUserId(Long userId);
    ArrayList<UserProject> findallByProjectId(Long projectId);
}
