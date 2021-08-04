package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.services.DeleteClassroomService;
import com.proyecto.apprendiendo.services.GetClassroomService;
import com.proyecto.apprendiendo.services.NewClassroomService;
import com.proyecto.apprendiendo.services.UpdateClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMAdminController {

    private NewClassroomService newClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;

    @PostMapping(path = "/class")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO){
        newClassroomService.execute(classroomDTO);
    }

    @GetMapping (path = "/class/{classroomId}")
    public ClassroomDTO getClassroom(@PathVariable Long classroomId){
        return getClassroomService.execute(classroomId);
    }

    @DeleteMapping(path = "/class/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId){
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "/class")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        updateClassroomService.execute(classroomDTO);
    }
}
