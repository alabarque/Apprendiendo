package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.User;
import com.proyecto.apprendiendo.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Long> {
    Optional<UserToken> findfirstByUsername(String username);
}
