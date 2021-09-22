package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.LessonDTO;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.CreateLessonService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.DeleteLessonService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.abm_services.lesson_services.UpdateLessonService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LessonController {

    private CreateLessonService createLessonService;
    private GetLessonService getLessonService;
    private DeleteLessonService deleteLessonService;
    private UpdateLessonService updateLessonService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "Lesson")
    public ResponseEntity<Long> newLesson(@RequestBody LessonDTO LessonDTO){
        return responseDecorator.decorate(()->createLessonService.execute(LessonDTO));
    }

    @GetMapping (path = "Lesson/{LessonId}")
    public ResponseEntity< LessonDTO> getLesson(@PathVariable Long LessonId){
        return responseDecorator.decorate(()->getLessonService.execute(LessonId));
    }

    @DeleteMapping(path = "Lesson/{LessonId}")
    public ResponseEntity<Long> deleteLesson(@PathVariable Long LessonId){
        return responseDecorator.decorate(()->deleteLessonService.execute(LessonId));
    }

    @PutMapping(path = "Lesson")
    public ResponseEntity<Long> updateLesson(@RequestBody LessonDTO LessonDTO){
        return responseDecorator.decorate(()->updateLessonService.execute(LessonDTO));
    }
}
