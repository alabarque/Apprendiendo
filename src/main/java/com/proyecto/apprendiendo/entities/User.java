package com.proyecto.apprendiendo.entities;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Long avatarId; //FK a Avatar
    protected String username;
    protected String password;
    protected String role;

    protected String firstName;
    protected String lastName;
    protected String homePhone;
    protected String mobilePhone;
    protected String address;
}
