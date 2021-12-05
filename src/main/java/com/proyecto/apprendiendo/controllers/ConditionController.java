package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ConditionDTO;
import com.proyecto.apprendiendo.services.general_services.condition_services.*;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ConditionController {

    private CreateConditionService createConditionService;
    private GetConditionService getConditionService;
    private DeleteConditionService deleteConditionService;
    private UpdateConditionService updateConditionService;
    private ResponseDecorator responseDecorator;
    private GetConditionsService getConditionsService;

    @PostMapping(path = "condition")
    public ResponseEntity<Long> newCondition(@RequestBody ConditionDTO ConditionDTO) {
        return responseDecorator.decorate(() -> createConditionService.execute(ConditionDTO));
    }

    @GetMapping(path = "condition/{ConditionId}")
    public ResponseEntity<ConditionDTO> getCondition(@PathVariable Long ConditionId) {
        return responseDecorator.decorate(() -> getConditionService.execute(ConditionId));
    }

    @GetMapping(path = "conditions")
    public ResponseEntity<ArrayList<ConditionDTO>> getConditions() {
        return responseDecorator.decorate(() -> getConditionsService.execute());
    }

    @DeleteMapping(path = "condition/{ConditionId}")
    public ResponseEntity<Long> deleteCondition(@PathVariable Long ConditionId) {
        return responseDecorator.decorate(() -> deleteConditionService.execute(ConditionId));
    }

    @PutMapping(path = "condition")
    public ResponseEntity<Long> updateCondition(@RequestBody ConditionDTO ConditionDTO) {
        return responseDecorator.decorate(() -> updateConditionService.execute(ConditionDTO));
    }
}
