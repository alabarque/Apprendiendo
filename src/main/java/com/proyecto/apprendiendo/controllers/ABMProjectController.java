package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.services.abm_services.project_services.*;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.AddProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.GetProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.RemoveProjectStudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private AddProjectStudentsService addProjectStudentsService;
    private RemoveProjectStudentsService removeProjectStudentsService;

    @PostMapping(path = "classroom/{classroomId}/project")
    public ResponseEntity<Long> newProject(@RequestBody ProjectNewDTO projectNewDTO, @PathVariable Long classroomId) {
        return new ResponseEntity<Long>(createProjectService.execute(projectNewDTO,classroomId), HttpStatus.OK);
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

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/add")
    public void addProjectStudents (@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId){
        addProjectStudentsService.execute(projectId, studentDTOs);
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/remove")
    public void removeProjectStudents (@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId){
        removeProjectStudentsService.execute(projectId, studentDTOs);
    }
}