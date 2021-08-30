package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.BadgeDTO;
import com.proyecto.apprendiendo.services.abm_services.reward_services.CreateBadgeService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.DeleteRewardService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.GetBadgeService;
import com.proyecto.apprendiendo.services.abm_services.reward_services.UpdateBadgeService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMBadgeController {

    private CreateBadgeService createBadgeService;
    private GetBadgeService getBadgeService;
    private DeleteRewardService deleteBadgeService;
    private UpdateBadgeService updateBadgeService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "badge")
    public ResponseEntity<Long> newBadge(@RequestBody BadgeDTO BadgeDTO){
        return responseDecorator.decorate(()->createBadgeService.execute(BadgeDTO));
    }

    @GetMapping (path = "badge/{BadgeId}")
    public ResponseEntity<BadgeDTO> getBadge(@PathVariable Long BadgeId){
        return responseDecorator.decorate(()->getBadgeService.execute(BadgeId));
    }

    @DeleteMapping(path = "badge/{BadgeId}")
    public ResponseEntity<Long> deleteBadge(@PathVariable Long BadgeId){
        return responseDecorator.decorate(()->deleteBadgeService.execute(BadgeId));
    }

    @PutMapping(path = "badge")
    public ResponseEntity<Long> updateBadge(@RequestBody BadgeDTO BadgeDTO){
        return responseDecorator.decorate(()->updateBadgeService.execute(BadgeDTO));
    }
}
