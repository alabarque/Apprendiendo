package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    ArrayList<User> findByRole(String role);
}
