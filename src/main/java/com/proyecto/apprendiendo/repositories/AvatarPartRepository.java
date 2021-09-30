package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.AvatarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarPartRepository extends JpaRepository<AvatarPart, Long> {}
