package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ChallengeDTO;
import com.proyecto.apprendiendo.services.abm_services.reward_services.CreateChallengeService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.DeleteRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.GetChallengeService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.UpdateChallengeService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMChallengeController {

    private CreateChallengeService createChallengeService;
    private GetChallengeService getChallengeService;
    private DeleteRewardService deleteChallengeService;
    private UpdateChallengeService updateChallengeService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "challenge")
    public ResponseEntity<Long> newChallenge(@RequestBody ChallengeDTO ChallengeDTO){
        return responseDecorator.decorate(()->createChallengeService.execute(ChallengeDTO));
    }

    @GetMapping (path = "challenge/{ChallengeId}")
    public ResponseEntity<ChallengeDTO> getChallenge(@PathVariable Long ChallengeId){
        return responseDecorator.decorate(()->getChallengeService.execute(ChallengeId));
    }

    @DeleteMapping(path = "challenge/{ChallengeId}")
    public ResponseEntity<Long> deleteChallenge(@PathVariable Long ChallengeId){
        return responseDecorator.decorate(()->deleteChallengeService.execute(ChallengeId));
    }

    @PutMapping(path = "challenge")
    public ResponseEntity<Long> updateChallenge(@RequestBody ChallengeDTO ChallengeDTO){
        return responseDecorator.decorate(()->updateChallengeService.execute(ChallengeDTO));
    }
}
