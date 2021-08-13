package com.proyecto.apprendiendo.entities;

import com.proyecto.apprendiendo.entities.enums.UserType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected String username;
    protected String password;
    protected UserType role;
}
