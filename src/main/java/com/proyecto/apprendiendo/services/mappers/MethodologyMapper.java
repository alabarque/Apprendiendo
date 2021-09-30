package com.proyecto.apprendiendo.services.mappers;


import com.proyecto.apprendiendo.entities.Methodology;
import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;

public class MethodologyMapper {
    public static MethodologyDTO entityToDto(Methodology methodology){

        return MethodologyDTO.builder()
                      .id(methodology.getId())
                      .name(methodology.getName())
                      .build();

    }
}
