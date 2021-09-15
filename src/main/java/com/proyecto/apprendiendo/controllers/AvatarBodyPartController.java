package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.CreateAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.DeleteAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.GetAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.UpdateAvatarBodyPartService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AvatarBodyPartController {

    private CreateAvatarBodyPartService createAvatarBodyPartService;
    private GetAvatarBodyPartService getAvatarBodyPartService;
    private DeleteAvatarBodyPartService deleteAvatarBodyPartService;
    private UpdateAvatarBodyPartService updateAvatarBodyPartService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "AvatarBodyPart")
    public ResponseEntity<Long> newAvatarBodyPart(@RequestBody AvatarBodyPartDTO AvatarBodyPartDTO){
        return responseDecorator.decorate(()->createAvatarBodyPartService.execute(AvatarBodyPartDTO));
    }

    @GetMapping (path = "AvatarBodyPart/{AvatarBodyPartId}")
    public ResponseEntity< AvatarBodyPartDTO> getAvatarBodyPart(@PathVariable Long AvatarBodyPartId){
        return responseDecorator.decorate(()->getAvatarBodyPartService.execute(AvatarBodyPartId));
    }

    @DeleteMapping(path = "AvatarBodyPart/{AvatarBodyPartId}")
    public ResponseEntity<Long> deleteAvatarBodyPart(@PathVariable Long AvatarBodyPartId){
        return responseDecorator.decorate(()->deleteAvatarBodyPartService.execute(AvatarBodyPartId));
    }

    @PutMapping(path = "AvatarBodyPart")
    public ResponseEntity<Long> updateAvatarBodyPart(@RequestBody AvatarBodyPartDTO AvatarBodyPartDTO){
        return responseDecorator.decorate(()->updateAvatarBodyPartService.execute(AvatarBodyPartDTO));
    }
}
