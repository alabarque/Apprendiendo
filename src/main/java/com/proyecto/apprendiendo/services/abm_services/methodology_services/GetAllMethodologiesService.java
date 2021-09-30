package com.proyecto.apprendiendo.services.abm_services.methodology_services;

import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.repositories.MethodologyRepository;
import com.proyecto.apprendiendo.services.mappers.MethodologyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetAllMethodologiesService {

    private MethodologyRepository methodologyRepository;

    public ArrayList<MethodologyDTO> execute() {
        return methodologyRepository.findAll()
                                    .stream()
                                    .map(methodology -> MethodologyMapper.entityToDto(methodology))
                                    .collect(Collectors.toCollection(ArrayList::new));
    }
}
