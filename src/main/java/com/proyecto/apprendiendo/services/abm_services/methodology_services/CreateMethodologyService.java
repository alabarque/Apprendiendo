package com.proyecto.apprendiendo.services.abm_services.methodology_services;

import com.proyecto.apprendiendo.entities.Methodology;
import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.repositories.MethodologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CreateMethodologyService {

    private MethodologyRepository methodologyRepository;

    public Long execute(MethodologyDTO methodologyDTO) {
        Methodology methodology = Methodology.builder().name(methodologyDTO.getName()).build();
        return methodologyRepository.save(methodology).getId();
    }
}
