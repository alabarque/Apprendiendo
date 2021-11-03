package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    ArrayList<Group> findByProjectId(Long projectId);
}
