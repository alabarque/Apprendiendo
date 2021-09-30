package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.DeleteAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.GetAvatarService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.UpdateAvatarService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AvatarController {

    private CreateAvatarService createAvatarService;
    private GetAvatarService getAvatarService;
    private DeleteAvatarService deleteAvatarService;
    private UpdateAvatarService updateAvatarService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "avatar")
    public ResponseEntity<Long> newAvatar(@RequestBody AvatarDTO AvatarDTO) {
        return responseDecorator.decorate(() -> createAvatarService.execute(AvatarDTO));
    }

    @GetMapping(path = "avatar/{AvatarId}")
    public ResponseEntity<AvatarDTO> getAvatar(@PathVariable Long AvatarId) {
        return responseDecorator.decorate(() -> getAvatarService.execute(AvatarId));
    }

    @DeleteMapping(path = "avatar/{AvatarId}")
    public ResponseEntity<Long> deleteAvatar(@PathVariable Long AvatarId) {
        return responseDecorator.decorate(() -> deleteAvatarService.execute(AvatarId));
    }

    @PutMapping(path = "avatar")
    public ResponseEntity<Long> updateAvatar(@RequestBody AvatarDTO AvatarDTO) {
        return responseDecorator.decorate(() -> updateAvatarService.execute(AvatarDTO));
    }
}
