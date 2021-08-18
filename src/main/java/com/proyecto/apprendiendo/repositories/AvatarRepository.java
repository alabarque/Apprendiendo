package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findByUserId (Long userId);
}
