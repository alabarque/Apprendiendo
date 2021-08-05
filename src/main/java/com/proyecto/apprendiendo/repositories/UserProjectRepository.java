package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject,Long> {
    //User findByUsername(String username);
}
