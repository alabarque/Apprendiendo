package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.template_services.*;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class TemplateController {

    private ResponseDecorator responseDecorator;
    private CreateStoredTemplateService createStoredTemplateService;
    private DeleteStoredTemplateService deleteStoredTemplateService;
    private UpdateStoredTemplateService updateStoredTemplateService;
    private GetStoredTemplateService getStoredTemplateService;
    private GetStoredTemplatesService getStoredTemplatesService;
    private AddTemplateReviewService addTemplateReviewService;

    @PostMapping(path = "template")
    public ResponseEntity<Long> newTemplate(@RequestBody StoredTemplateDTO storedTemplateDTO) {
        return responseDecorator.decorate(() -> createStoredTemplateService.execute(storedTemplateDTO));
    }

    @PostMapping(path = "template/review")
    public ResponseEntity<Long> reviewTemplate(@RequestBody TemplateReviewDTO templateReviewDTO) {
        return responseDecorator.decorate(() -> addTemplateReviewService.execute(templateReviewDTO));
    }
    @GetMapping(path = "template/{templateId}")
    public ResponseEntity<StoredTemplateDTO> getTemplate(@PathVariable Long templateId) {
        return responseDecorator.decorate(() -> getStoredTemplateService.execute(templateId));
    }

    @GetMapping(path = "templates/projects")
    public ResponseEntity<ArrayList<StoredTemplateMetadataDTO>> getAllProjectTemplates() {
        return responseDecorator.decorate(() -> getStoredTemplatesService.execute("PROJECT"));
    }

    @GetMapping(path = "templates/lessons")
    public ResponseEntity<ArrayList<StoredTemplateMetadataDTO>> getAllLessonTemplates() {
        return responseDecorator.decorate(() -> getStoredTemplatesService.execute("LESSON"));
    }

    @GetMapping(path = "templates/activities")
    public ResponseEntity<ArrayList<StoredTemplateMetadataDTO>> getAllActivityTemplates() {
        return responseDecorator.decorate(() -> getStoredTemplatesService.execute("ACTIVITY"));
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
