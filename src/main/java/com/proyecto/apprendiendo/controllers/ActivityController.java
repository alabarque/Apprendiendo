package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.general_services.activity_services.DeleteActivityService;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.activity_services.UpdateActivityService;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetActivityStudentsProgressService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ActivityController {

    private CreateActivityService createActivityService;
    private GetActivityService getActivityService;
    private DeleteActivityService deleteActivityService;
    private UpdateActivityService updateActivityService;
    private ResponseDecorator responseDecorator;
    private GetActivityStudentsProgressService getActivityStudentsProgressService;
    private GetSourcesDocumentsService getSourcesDocumentsService;

    @PostMapping(path = "activity")
    public ResponseEntity<Long> newActivity(@RequestBody ActivityDTO activityDTO) {
        return responseDecorator.decorate(() -> createActivityService.execute(activityDTO));
    }

    @GetMapping(path = "activity/{activityId}")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long activityId) {
        return responseDecorator.decorate(() -> getActivityService.execute(activityId));
    }

    @DeleteMapping(path = "activity/{activityId}")
    public ResponseEntity<Long> deleteActivity(@PathVariable Long activityId) {
        return responseDecorator.decorate(() -> deleteActivityService.execute(activityId));
    }

    @PutMapping(path = "activity")
    public ResponseEntity<Long> updateActivity(@RequestBody ActivityDTO activityDTO) {
        return responseDecorator.decorate(() -> updateActivityService.execute(activityDTO));
    }

    @GetMapping(path = "activity/{activityId}/progress")
    public ResponseEntity<ArrayList<StudentActivityDTO>> getActivityProgress(@PathVariable Long activityId) {
        return responseDecorator.decorate(() -> getActivityStudentsProgressService.execute(activityId));
    }

    @GetMapping(path = "activity/{activityId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getActivityDocuments(@PathVariable("activityId") Long activityId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(activityId));
    }
}
