package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Activity;
import com.proyecto.apprendiendo.entities.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
