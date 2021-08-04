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
public class ABMUserController {

    private NewClassroomService newClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;

    @PostMapping(path = "/user")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO){
        newClassroomService.execute(classroomDTO);
    }

    @GetMapping (path = "/user/{userId}")
    public ClassroomDTO getClassroom(@PathVariable Long classroomId){
        return getClassroomService.execute(classroomId);
    }

    @DeleteMapping(path = "/user/{userId}")
    public void deleteClassroom(@PathVariable Long classroomId){
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "/class")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        updateClassroomService.execute(classroomDTO);
    }
}
