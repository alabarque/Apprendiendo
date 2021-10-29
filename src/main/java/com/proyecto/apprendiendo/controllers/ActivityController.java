package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.activity_services.*;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
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
    private GetTargetRewardsService getTargetRewardsService;
    private GetActivityTemplateService getActivityTemplateService;
    private CreateActivityFromTemplateService createActivityFromTemplateService;

    @PostMapping(path = "activity")
    public ResponseEntity<Long> newActivity(@RequestBody ActivityDTO activityDTO) {
        return responseDecorator.decorate(() -> createActivityService.execute(activityDTO));
    }

    @PostMapping(path = "lesson/{lessonId}/activity/template")
    public ResponseEntity<Long> newActivityFromTemplate(@RequestBody ActivityTemplateDTO activityTemplateDTO, @PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> createActivityFromTemplateService.execute(activityTemplateDTO, lessonId));
    }

    @GetMapping(path = "activity/{activityId}")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long activityId) {
        return responseDecorator.decorate(() -> getActivityService.execute(activityId));
    }

    @GetMapping(path = "activity/{activityId}/template")
    public ResponseEntity<ActivityTemplateDTO> getActivityAsTemplate(@PathVariable Long activityId) {
        return responseDecorator.decorate(() -> getActivityTemplateService.execute(activityId));
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

    @GetMapping(path = "activity/{activityId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getActivityDocumentsSummary(@PathVariable("activityId") Long activityId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(activityId, "SUMMARY"));
    }

    @GetMapping(path = "activity/{activityId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getActivityDocumentsSelective(@PathVariable("activityId") Long activityId, @RequestParam(required = false) String type) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(activityId, "SELECTIVE", type));
    }

    @GetMapping(path = "activity/{activityId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getActivityRewards(@PathVariable("activityId") Long activityId) {
        return responseDecorator.decorate(() -> getTargetRewardsService.execute(activityId));
    }
}
