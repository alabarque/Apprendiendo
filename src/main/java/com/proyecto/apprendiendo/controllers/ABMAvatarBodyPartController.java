package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.AvatarBodyPartDTO;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.CreateAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.DeleteAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.GetAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.UpdateAvatarBodyPartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMAvatarBodyPartController {

    private CreateAvatarBodyPartService createAvatarBodyPartService;
    private GetAvatarBodyPartService getAvatarBodyPartService;
    private DeleteAvatarBodyPartService deleteAvatarBodyPartService;
    private UpdateAvatarBodyPartService updateAvatarBodyPartService;

    @PostMapping(path = "AvatarBodyPart")
    public void newAvatarBodyPart(@RequestBody AvatarBodyPartDTO AvatarBodyPartDTO){
        createAvatarBodyPartService.execute(AvatarBodyPartDTO);
    }

    @GetMapping (path = "AvatarBodyPart/{AvatarBodyPartId}")
    public AvatarBodyPartDTO getAvatarBodyPart(@PathVariable Long AvatarBodyPartId){
        return getAvatarBodyPartService.execute(AvatarBodyPartId);
    }

    @DeleteMapping(path = "AvatarBodyPart/{AvatarBodyPartId}")
    public void deleteAvatarBodyPart(@PathVariable Long AvatarBodyPartId){
        deleteAvatarBodyPartService.execute(AvatarBodyPartId);
    }

    @PutMapping(path = "AvatarBodyPart")
    public void updateAvatarBodyPart(@RequestBody AvatarBodyPartDTO AvatarBodyPartDTO){
        updateAvatarBodyPartService.execute(AvatarBodyPartDTO);
    }
}
