package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.services.abm_services.methodology_services.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ABMMethodologyController {

    private CreateMethodologyService createMethodologyService;
    private GetMethodologyService getMethodologyService;
    private DeleteMethodologyService deleteMethodologyService;
    private UpdateMethodologyService updateMethodologyService;

    @PostMapping(path = "methodology")
    public void newMethodology(@RequestBody MethodologyDTO methodologyDTO) {
        createMethodologyService.execute(methodologyDTO);
    }

    @GetMapping(path = "methodology/{methodologyId}")
    public MethodologyDTO getMethodology(@PathVariable Long methodologyId) {
        return getMethodologyService.execute(methodologyId);
    }

    @DeleteMapping(path = "methodology/{methodologyId}")
    public void deleteMethodology(@PathVariable Long methodologyId) {
        deleteMethodologyService.execute(methodologyId);
    }

    @PutMapping(path = "methodology")
    public void updateMethodology(@RequestBody MethodologyDTO methodologyDTO) {
        updateMethodologyService.execute(methodologyDTO);
    }
}
