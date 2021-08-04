package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO.ClassroomDTO;
import com.proyecto.apprendiendo.services.ClassroomService.DeleteClassroomService;
import com.proyecto.apprendiendo.services.ClassroomService.GetClassroomService;
import com.proyecto.apprendiendo.services.ClassroomService.NewClassroomService;
import com.proyecto.apprendiendo.services.ClassroomService.UpdateClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMClassroomController {

    private NewClassroomService newClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;

    @PostMapping(path = "/classroom")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO){
        newClassroomService.execute(classroomDTO);
    }

    @GetMapping (path = "/classroom/{classroomId}")
    public ClassroomDTO getClassroom(@PathVariable Long classroomId){
        return getClassroomService.execute(classroomId);
    }

    @DeleteMapping(path = "/classroom/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId){
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "/classroom")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        updateClassroomService.execute(classroomDTO);
    }
}
