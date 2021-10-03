package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {}
