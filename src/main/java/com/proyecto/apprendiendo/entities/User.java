package com.proyecto.apprendiendo.entities;

import com.proyecto.apprendiendo.entities.interfaces.Source;
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
public class User implements Source {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected String username;
    protected String password;
    protected String role;

}
