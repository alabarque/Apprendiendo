package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AvatarPartDTO;
import com.proyecto.apprendiendo.services.abm_services.avatar_part_services.CreateAvatarPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_part_services.DeleteAvatarPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_part_services.GetAvatarPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_part_services.UpdateAvatarPartService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AvatarPartController {

    private CreateAvatarPartService createAvatarPartService;
    private GetAvatarPartService getAvatarPartService;
    private DeleteAvatarPartService deleteAvatarPartService;
    private UpdateAvatarPartService updateAvatarPartService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "AvatarPart")
    public ResponseEntity<Long> newAvatarPart(@RequestBody AvatarPartDTO AvatarPartDTO) {
        return responseDecorator.decorate(() -> createAvatarPartService.execute(AvatarPartDTO));
    }

    @GetMapping(path = "AvatarPart/{AvatarPartId}")
    public ResponseEntity<AvatarPartDTO> getAvatarPart(@PathVariable Long AvatarPartId) {
        return responseDecorator.decorate(() -> getAvatarPartService.execute(AvatarPartId));
    }

    @DeleteMapping(path = "AvatarPart/{AvatarPartId}")
    public ResponseEntity<Long> deleteAvatarPart(@PathVariable Long AvatarPartId) {
        return responseDecorator.decorate(() -> deleteAvatarPartService.execute(AvatarPartId));
    }

    @PutMapping(path = "AvatarPart")
    public ResponseEntity<Long> updateAvatarPart(@RequestBody AvatarPartDTO AvatarPartDTO) {
        return responseDecorator.decorate(() -> updateAvatarPartService.execute(AvatarPartDTO));
    }
}
