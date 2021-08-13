package com.proyecto.apprendiendo.entities.dtos;

import com.proyecto.apprendiendo.entities.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentDTO {
    protected Long id;
    protected String username;
}
