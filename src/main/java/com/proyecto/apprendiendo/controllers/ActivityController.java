package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.services.abm_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.abm_services.activity_services.DeleteActivityService;
import com.proyecto.apprendiendo.services.abm_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.abm_services.activity_services.UpdateActivityService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ActivityController {

    private CreateActivityService createActivityService;
    private GetActivityService getActivityService;
    private DeleteActivityService deleteActivityService;
    private UpdateActivityService updateActivityService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "Activity")
    public ResponseEntity<Long> newActivity(@RequestBody ActivityDTO ActivityDTO){
        return responseDecorator.decorate(()->createActivityService.execute(ActivityDTO));
    }

    @GetMapping (path = "Activity/{ActivityId}")
    public ResponseEntity< ActivityDTO> getActivity(@PathVariable Long ActivityId){
        return responseDecorator.decorate(()->getActivityService.execute(ActivityId));
    }

    @DeleteMapping(path = "Activity/{ActivityId}")
    public ResponseEntity<Long> deleteActivity(@PathVariable Long ActivityId){
        return responseDecorator.decorate(()->deleteActivityService.execute(ActivityId));
    }

    @PutMapping(path = "Activity")
    public ResponseEntity<Long> updateActivity(@RequestBody ActivityDTO ActivityDTO){
        return responseDecorator.decorate(()->updateActivityService.execute(ActivityDTO));
    }
}
