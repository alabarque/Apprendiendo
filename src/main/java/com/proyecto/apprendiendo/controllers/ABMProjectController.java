package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.services.abm_services.project_services.DeleteProjectService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.abm_services.project_services.CreateProjectService;
import com.proyecto.apprendiendo.services.abm_services.project_services.UpdateProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ABMProjectController {

    private CreateProjectService createProjectService;
    private GetProjectService getProjectService;
    private DeleteProjectService deleteProjectService;
    private UpdateProjectService updateProjectService;

    @PostMapping(path = "classroom/{classroomId}/project")
    public void newProject(@RequestBody ProjectNewDTO projectNewDTO, @PathVariable Long classroomId){ createProjectService.execute(projectNewDTO, classroomId); }

    @GetMapping (path = "classroom/{classroomId}/project/{projectId}")
    public ProjectDTO getProject(@PathVariable("projectId") Long projectId){
        return getProjectService.execute(projectId);
    }

    @DeleteMapping(path = "classroom/{classroomId}/project/{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId){
        deleteProjectService.execute(projectId);
    }

    @PutMapping(path = "classroom/{classroomId}/project")
    public void updateProject(@RequestBody ProjectDTO projectDTO){
        updateProjectService.execute(projectDTO);
    }

}