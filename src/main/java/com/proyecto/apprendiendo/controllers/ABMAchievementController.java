package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AchievementDTO;
import com.proyecto.apprendiendo.services.abm_services.reward_services.CreateAchievementService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.DeleteRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.GetAchievementService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.UpdateAchievementService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMAchievementController {

    private CreateAchievementService createAchievementService;
    private GetAchievementService getAchievementService;
    private DeleteRewardService deleteAchievementService;
    private UpdateAchievementService updateAchievementService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "achievement")
    public ResponseEntity<Long> newAchievement(@RequestBody AchievementDTO AchievementDTO){
        return responseDecorator.decorate(()->createAchievementService.execute(AchievementDTO));
    }

    @GetMapping (path = "achievement/{AchievementId}")
    public ResponseEntity<AchievementDTO> getAchievement(@PathVariable Long AchievementId){
        return responseDecorator.decorate(()->getAchievementService.execute(AchievementId));
    }

    @DeleteMapping(path = "achievement/{AchievementId}")
    public ResponseEntity<Long> deleteAchievement(@PathVariable Long AchievementId){
        return responseDecorator.decorate(()->deleteAchievementService.execute(AchievementId));
    }

    @PutMapping(path = "achievement")
    public ResponseEntity<Long> updateAchievement(@RequestBody AchievementDTO AchievementDTO){
        return responseDecorator.decorate(()->updateAchievementService.execute(AchievementDTO));
    }
}
