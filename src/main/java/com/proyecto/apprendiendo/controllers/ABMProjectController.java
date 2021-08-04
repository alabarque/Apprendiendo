package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.NewProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;
import com.proyecto.apprendiendo.services.ProjectService.DeleteProjectService;
import com.proyecto.apprendiendo.services.ProjectService.GetProjectService;
import com.proyecto.apprendiendo.services.ProjectService.NewProjectService;
import com.proyecto.apprendiendo.services.ProjectService.UpdateProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ABMProjectController {

    private NewProjectService newProjectService;
    private GetProjectService getProjectService;
    private DeleteProjectService deleteProjectService;
    private UpdateProjectService updateProjectService;

    @PostMapping(path = "/classroom/{classroomId}/project")
    public void newProject(@RequestBody NewProjectDTO newProjectDTO, @PathVariable Long classroomId){ newProjectService.execute(newProjectDTO, classroomId); }

    @GetMapping (path = "/classroom/{classroomId}/project/{projectId}")
    public ProjectDTO getProject(@PathVariable("projectId") Long projectId){
        return getProjectService.execute(projectId);
    }

    @DeleteMapping(path = "/classroom/{classroomId}/project/{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId){
        deleteProjectService.execute(projectId);
    }

    @PutMapping(path = "/classroom/{classroomId}/project")
    public void updateProject(@RequestBody ProjectDTO projectDTO){
        updateProjectService.execute(projectDTO);
    }

}