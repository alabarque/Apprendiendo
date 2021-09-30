package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.MethodologyDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.services.abm_services.methodology_services.*;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectTemplateByMethodologyIdService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectTemplateByNameService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@AllArgsConstructor
public class MethodologyController {

    private CreateMethodologyService createMethodologyService;
    private GetMethodologyService getMethodologyService;
    private DeleteMethodologyService deleteMethodologyService;
    private UpdateMethodologyService updateMethodologyService;
    private GetAllMethodologiesService getAllMethodologiesService;
    private ResponseDecorator responseDecorator;
    private GetProjectTemplateByMethodologyIdService getProjectTemplateByMethodologyIdService;
    private GetProjectTemplateByNameService getProjectTemplateByNameService;


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


    @GetMapping(path = "methodology/invertedclassroom/project/template")
    public ResponseEntity<ProjectTemplateDTO> getInvertedClassroomTemplate() {
        return responseDecorator.decorate(()-> getProjectTemplateByNameService.execute("Nuevo Proyecto de Aula Invertida"));
    }

    @GetMapping(path = "methodology/pbl/project/template")
    public ResponseEntity<ProjectTemplateDTO> getPBLTemplate() {
        return responseDecorator.decorate(()-> getProjectTemplateByNameService.execute("Nuevo Proyecto de PBL"));
    }

    @GetMapping(path = "methodology/tbl/project/template")
    public ResponseEntity<ProjectTemplateDTO> getTBLTemplate() {
        return responseDecorator.decorate(()-> getProjectTemplateByNameService.execute("Nuevo Proyecto de TBL"));
    }

    @GetMapping(path = "methodology/{methodologyId}/project/template")
    public ResponseEntity<ProjectTemplateDTO> getMethodologyTemplate(@PathVariable Long methodologyId) {
        return responseDecorator.decorate(()-> getProjectTemplateByMethodologyIdService.execute(methodologyId));
    }


}
