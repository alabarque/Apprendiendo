package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.services.DeleteClassroomService;
import com.proyecto.apprendiendo.services.GetClassroomService;
import com.proyecto.apprendiendo.services.NewClassroomService;
import com.proyecto.apprendiendo.services.UpdateClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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

    @GetMapping (path = "/class/{id}")
    public ClassroomDTO getClassroom(@PathVariable Long idClass){
        return getClassroomService.execute(idClass);
    }

    @DeleteMapping(path = "/class/{id}")
    public void deleteClassroom(@PathVariable Long classroomId){
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "/class")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        updateClassroomService.execute(classroomDTO);
    }
}
