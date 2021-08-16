package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.AvatarBodyPart;
import com.proyecto.apprendiendo.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarBodyPartRepository extends JpaRepository<AvatarBodyPart, Long> {
}
