package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.services.GetClassroomService;
import com.proyecto.apprendiendo.services.NewClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ABMAdminController {

    NewClassroomService newClassroomService;
    GetClassroomService getClassroomService;

    @PostMapping(path = "/class")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO){
        newClassroomService.execute(classroomDTO);
    }

    @GetMapping (path = "/class/{id}")
    public ClassroomDTO getClassroom(@PathVariable Long idClass){
        return getClassroomService.execute(idClass);
    }
}
