package com.proyecto.apprendiendo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ResponseIdDTO implements Serializable {
    private Long id;
}
