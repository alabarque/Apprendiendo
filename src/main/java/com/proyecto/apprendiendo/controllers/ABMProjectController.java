package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.NewProjectDTO;
import com.proyecto.apprendiendo.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ABMProjectController {

    private NewProjectService newProjectService;

    @PostMapping(path = "/classroom/{classroomId}/project")
    public void newProject(@RequestBody NewProjectDTO newProjectDTO, @PathVariable Long classroomId){ newProjectService.execute(newProjectDTO, classroomId); }

}