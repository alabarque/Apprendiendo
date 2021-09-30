package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentLessonDTO;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.*;
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

    @PostMapping(path = "lesson")
    public ResponseEntity<Long> newLesson(@RequestBody LessonDTO lessonDTO){
        return responseDecorator.decorate(()->createLessonService.execute(lessonDTO));
    }

    @GetMapping (path = "lesson/{lessonId}")
    public ResponseEntity< LessonDTO> getLesson(@PathVariable Long lessonId){
        return responseDecorator.decorate(()->getLessonService.execute(lessonId));
    }

    @DeleteMapping(path = "lesson/{lessonId}")
    public ResponseEntity<Long> deleteLesson(@PathVariable Long lessonId){
        return responseDecorator.decorate(()->deleteLessonService.execute(lessonId));
    }

    @PutMapping(path = "lesson")
    public ResponseEntity<Long> updateLesson(@RequestBody LessonDTO lessonDTO) {
        return responseDecorator.decorate(() -> updateLessonService.execute(lessonDTO));
    }

    @GetMapping(path = "lesson/{lessonId}/activities")
    public ResponseEntity<ArrayList<ActivityDTO>> getProjectActivities(@PathVariable("lessonId") Long lessonId) {
        return responseDecorator.decorate(()-> getLessonActivitiesService.execute(lessonId));
    }

    @GetMapping(path = "lesson/{lessonId}/students/progress")
    public ResponseEntity<ArrayList<StudentLessonDTO>> getLessonStudentsProgress(@PathVariable("lessonId") Long lessonId) {
        return responseDecorator.decorate(()->getLessonStudentsProgressService.execute(lessonId));
    }
}
