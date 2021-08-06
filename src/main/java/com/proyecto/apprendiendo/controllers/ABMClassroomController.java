package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.DeleteClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.UpdateClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMClassroomController {

    private CreateClassroomService createClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;

    @PostMapping(path = "classroom")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO){
        createClassroomService.execute(classroomDTO);
    }

    @GetMapping (path = "classroom/{classroomId}")
    public ClassroomDTO getClassroom(@PathVariable Long classroomId){
        return getClassroomService.execute(classroomId);
    }

    @DeleteMapping(path = "classroom/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId){
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "classroom")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        updateClassroomService.execute(classroomDTO);
    }
}
