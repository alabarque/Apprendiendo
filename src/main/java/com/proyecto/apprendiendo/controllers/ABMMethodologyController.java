package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.services.abm_services.methodology_services.*;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@AllArgsConstructor
public class ABMMethodologyController {

    private CreateMethodologyService createMethodologyService;
    private GetMethodologyService getMethodologyService;
    private DeleteMethodologyService deleteMethodologyService;
    private UpdateMethodologyService updateMethodologyService;
    private GetAllMethodologiesService getAllMethodologiesService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "methodology")
    public ResponseEntity<Long> newMethodology(@RequestBody MethodologyDTO methodologyDTO) {
        return responseDecorator.decorate(()->createMethodologyService.execute(methodologyDTO));
    }

    @GetMapping(path = "methodologies")
    public ResponseEntity< ArrayList<MethodologyDTO>> getAllMethodologies() {
        return responseDecorator.decorate(()-> getAllMethodologiesService.execute());
    }

    @GetMapping(path = "methodology/{methodologyId}")
    public ResponseEntity<MethodologyDTO> getMethodology(@PathVariable Long methodologyId) {
        return responseDecorator.decorate(()-> getMethodologyService.execute(methodologyId));
    }

    @DeleteMapping(path = "methodology/{methodologyId}")
    public ResponseEntity<Long> deleteMethodology(@PathVariable Long methodologyId) {
        return responseDecorator.decorate(()->deleteMethodologyService.execute(methodologyId));
    }

    @PutMapping(path = "methodology")
    public ResponseEntity<Long> updateMethodology(@RequestBody MethodologyDTO methodologyDTO) {
        return responseDecorator.decorate(()->updateMethodologyService.execute(methodologyDTO));
    }
}
