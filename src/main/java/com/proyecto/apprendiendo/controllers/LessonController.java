package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.*;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class LessonController {

    private CreateLessonService createLessonService;
    private GetLessonService getLessonService;
    private DeleteLessonService deleteLessonService;
    private UpdateLessonService updateLessonService;
    private ResponseDecorator responseDecorator;
    private GetLessonActivitiesService getLessonActivitiesService;
    private GetLessonStudentsProgressService getLessonStudentsProgressService;
    private CreateLessonFromTemplateService createLessonFromTemplateService;
    private GetSourcesDocumentsService getSourcesDocumentsService;
    private GetLessonTemplateService getLessonTemplateService;

    @PostMapping(path = "lesson")
    public ResponseEntity<Long> newLesson(@RequestBody LessonDTO lessonDTO) {
        return responseDecorator.decorate(() -> createLessonService.execute(lessonDTO));
    }

    @PostMapping(path = "project/{projectId}/lesson/template")
    public ResponseEntity<Long> newLessonFromTemplate(@RequestBody LessonTemplateDTO lessonTemplateDTO, @PathVariable Long projectId) {
        return responseDecorator.decorate(() -> createLessonFromTemplateService.execute(lessonTemplateDTO, projectId));
    }

    @GetMapping(path = "lesson/{lessonId}")
    public ResponseEntity<LessonDTO> getLesson(@PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> getLessonService.execute(lessonId));
    }

    @GetMapping(path = "lesson/{lessonId}/template")
    public ResponseEntity<LessonTemplateDTO> getLessonAsTemplate(@PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> getLessonTemplateService.execute(lessonId));
    }

    @DeleteMapping(path = "lesson/{lessonId}")
    public ResponseEntity<Long> deleteLesson(@PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> deleteLessonService.execute(lessonId));
    }

    @PutMapping(path = "lesson")
    public ResponseEntity<Long> updateLesson(@RequestBody LessonDTO lessonDTO) {
        return responseDecorator.decorate(() -> updateLessonService.execute(lessonDTO));
    }

    @GetMapping(path = "lesson/{lessonId}/activities")
    public ResponseEntity<ArrayList<ActivityDTO>> getLessonActivities(@PathVariable("lessonId") Long lessonId) {
        return responseDecorator.decorate(() -> getLessonActivitiesService.execute(lessonId));
    }

    @GetMapping(path = "lesson/{lessonId}/students/progress")
    public ResponseEntity<ArrayList<StudentLessonDTO>> getLessonStudentsProgress(@PathVariable("lessonId") Long lessonId) {
        return responseDecorator.decorate(() -> getLessonStudentsProgressService.execute(lessonId));
    }

    @GetMapping(path = "lesson/{lessonId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getLessonDocuments(@PathVariable("lessonId") Long lessonId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(lessonId));
    }
}
