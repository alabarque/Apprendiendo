package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.services.abm_services.project_services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class ABMProjectController {

    private CreateProjectService createProjectService;
    private GetProjectService getProjectService;
    private DeleteProjectService deleteProjectService;
    private UpdateProjectService updateProjectService;
    private GetProjectStudentsService getProjectStudentsService;
    private UpdateProjectStudentsService updateProjectStudentsService;

    @PostMapping(path = "classroom/{classroomId}/project")
    public void newProject(@RequestBody ProjectNewDTO projectNewDTO, @PathVariable Long classroomId) {
        createProjectService.execute(projectNewDTO,
                                     classroomId);
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}")
    public ProjectDTO getProject(@PathVariable("projectId") Long projectId) {
        return getProjectService.execute(projectId);
    }

    @DeleteMapping(path = "classroom/{classroomId}/project/{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId) {
        deleteProjectService.execute(projectId);
    }

    @PutMapping(path = "classroom/{classroomId}/project")
    public void updateProject(@RequestBody ProjectDTO projectDTO) {
        updateProjectService.execute(projectDTO);
    }


    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/students")
    public ArrayList<StudentDTO> getProjectStudents(@PathVariable("projectId") Long projectId) {
        return getProjectStudentsService.execute(projectId);
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students")
    public void updateProjectStudents (@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId){
        updateProjectStudentsService.execute(projectId, studentDTOs);
    }
}