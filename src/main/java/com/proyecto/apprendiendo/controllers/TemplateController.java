package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.template_services.CreateStoredTemplateService;
import com.proyecto.apprendiendo.services.general_services.template_services.DeleteStoredTemplateService;
import com.proyecto.apprendiendo.services.general_services.template_services.GetStoredTemplateService;
import com.proyecto.apprendiendo.services.general_services.template_services.UpdateStoredTemplateService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TemplateController {

    private ResponseDecorator responseDecorator;
    private CreateStoredTemplateService createStoredTemplateService;
    private DeleteStoredTemplateService deleteStoredTemplateService;
    private UpdateStoredTemplateService updateStoredTemplateService;
    private GetStoredTemplateService getStoredTemplateService;

    @PostMapping(path = "template")
    public ResponseEntity<Long> newTemplate(@RequestBody StoredTemplateDTO storedTemplateDTO) {
        return responseDecorator.decorate(() -> createStoredTemplateService.execute(storedTemplateDTO));
    }

    @GetMapping(path = "template/{templateId}")
    public ResponseEntity<StoredTemplateDTO> getTemplate(@PathVariable Long templateId) {
        return responseDecorator.decorate(() -> getStoredTemplateService.execute(templateId));
    }

    @DeleteMapping(path = "template/{templateId}")
    public ResponseEntity<Long> deleteTemplate(@PathVariable Long templateId) {
        return responseDecorator.decorate(() -> deleteStoredTemplateService.execute(templateId));
    }

    @PutMapping(path = "template")
    public ResponseEntity<Long> updateTemplate(@RequestBody StoredTemplateDTO storedTemplateDTO) {
        return responseDecorator.decorate(() -> updateStoredTemplateService.execute(storedTemplateDTO));
    }
}
