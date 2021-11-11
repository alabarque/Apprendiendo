package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="USERS")
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String username;
    protected String password;
    protected String role;

    protected String firstName;
    protected String lastName;
    protected String homePhone;
    protected String mobilePhone;
    protected String address;

    protected Long avatarId; //FK a Avatar
    protected Integer studentYear;
    protected String studentDivision;
    protected String imageData;
}
