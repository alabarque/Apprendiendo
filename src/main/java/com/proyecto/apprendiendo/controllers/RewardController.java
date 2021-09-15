package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.RewardDTO;
import com.proyecto.apprendiendo.services.abm_services.reward_services.CreateRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.DeleteRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.GetRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.UpdateRewardService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RewardController {

    private CreateRewardService createRewardService;
    private GetRewardService getRewardService;
    private DeleteRewardService deleteRewardService;
    private UpdateRewardService updateRewardService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "reward")
    public ResponseEntity<Long> newReward(@RequestBody RewardDTO RewardDTO){
        return responseDecorator.decorate(()->createRewardService.execute(RewardDTO));
    }

    @GetMapping (path = "reward/{RewardId}")
    public ResponseEntity<RewardDTO> getReward(@PathVariable Long RewardId){
        return responseDecorator.decorate(()->getRewardService.execute(RewardId));
    }

    @DeleteMapping(path = "reward/{RewardId}")
    public ResponseEntity<Long> deleteReward(@PathVariable Long RewardId){
        return responseDecorator.decorate(()->deleteRewardService.execute(RewardId));
    }

    @PutMapping(path = "reward")
    public ResponseEntity<Long> updateReward(@RequestBody RewardDTO RewardDTO){
        return responseDecorator.decorate(()->updateRewardService.execute(RewardDTO));
    }
}
