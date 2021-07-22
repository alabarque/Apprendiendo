package com.proyecto.apprendiendo.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@Entity
public class User {
    @Id
    protected Long id;
    protected String username;
    protected String password;
    protected String role;

}
