package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="USER_TOKEN")
@Table(name="USER_TOKEN")
public class UserToken {
    @Id
    private String username;
    private String token;
}
