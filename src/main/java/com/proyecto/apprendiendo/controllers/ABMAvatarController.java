package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.DeleteAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.GetAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.UpdateAvatarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMAvatarController {

    private CreateAvatarService createAvatarService;
    private GetAvatarService getAvatarService;
    private DeleteAvatarService deleteAvatarService;
    private UpdateAvatarService updateAvatarService;

    @PostMapping(path = "Avatar")
    public void newAvatar(@RequestBody AvatarDTO AvatarDTO){
        createAvatarService.execute(AvatarDTO);
    }

    @GetMapping (path = "Avatar/{AvatarId}")
    public AvatarDTO getAvatar(@PathVariable Long AvatarId){
        return getAvatarService.execute(AvatarId);
    }

    @DeleteMapping(path = "Avatar/{AvatarId}")
    public void deleteAvatar(@PathVariable Long AvatarId){
        deleteAvatarService.execute(AvatarId);
    }

    @PutMapping(path = "Avatar")
    public void updateAvatar(@RequestBody AvatarDTO AvatarDTO){
        updateAvatarService.execute(AvatarDTO);
    }
}
