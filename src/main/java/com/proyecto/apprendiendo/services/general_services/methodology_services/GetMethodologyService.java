package com.proyecto.apprendiendo.services.general_services.methodology_services;

import com.proyecto.apprendiendo.entities.Methodology;
import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.repositories.MethodologyRepository;
import com.proyecto.apprendiendo.services.mappers.MethodologyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetMethodologyService {

    private MethodologyRepository methodologyRepository;

    public MethodologyDTO execute(Long idClass) {
        Methodology methodology = methodologyRepository.getById(idClass);
        return MethodologyMapper.entityToDto(methodology);
    }
}
