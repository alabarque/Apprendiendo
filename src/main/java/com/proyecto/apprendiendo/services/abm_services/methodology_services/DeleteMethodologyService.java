package com.proyecto.apprendiendo.services.abm_services.methodology_services;

import com.proyecto.apprendiendo.repositories.MethodologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteMethodologyService {

    private MethodologyRepository methodologyRepository;

    public Long execute(Long methodologyId) {
        methodologyRepository.deleteById(methodologyId);
        return methodologyId;
    }
}
