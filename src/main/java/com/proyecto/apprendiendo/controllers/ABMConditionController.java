package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.services.abm_services.condition_services.CreateConditionService;
import com.proyecto.apprendiendo.services.abm_services.condition_services.DeleteConditionService;
import com.proyecto.apprendiendo.services.abm_services.condition_services.GetConditionService;
import com.proyecto.apprendiendo.services.abm_services.condition_services.UpdateConditionService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMConditionController {

    private CreateConditionService createConditionService;
    private GetConditionService getConditionService;
    private DeleteConditionService deleteConditionService;
    private UpdateConditionService updateConditionService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "condition")
    public ResponseEntity<Long> newCondition(@RequestBody ConditionDTO ConditionDTO){
        return responseDecorator.decorate(()->createConditionService.execute(ConditionDTO));
    }

    @GetMapping (path = "condition/{ConditionId}")
    public ResponseEntity<ConditionDTO> getCondition(@PathVariable Long ConditionId){
        return responseDecorator.decorate(()->getConditionService.execute(ConditionId));
    }

    @DeleteMapping(path = "condition/{ConditionId}")
    public ResponseEntity<Long> deleteCondition(@PathVariable Long ConditionId){
        return responseDecorator.decorate(()->deleteConditionService.execute(ConditionId));
    }

    @PutMapping(path = "condition")
    public ResponseEntity<Long> updateCondition(@RequestBody ConditionDTO ConditionDTO){
        return responseDecorator.decorate(()->updateConditionService.execute(ConditionDTO));
    }
}
