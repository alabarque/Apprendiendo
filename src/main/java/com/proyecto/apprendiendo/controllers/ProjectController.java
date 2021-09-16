package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.services.abm_services.project_services.*;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.AddProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.RemoveProjectStudentsService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ProjectController {

    private CreateProjectService createProjectService;
    private GetProjectService getProjectService;
    private DeleteProjectService deleteProjectService;
    private UpdateProjectService updateProjectService;
    private GetProjectStudentsService getProjectStudentsService;
    private AddProjectStudentsService addProjectStudentsService;
    private RemoveProjectStudentsService removeProjectStudentsService;
    private ResponseDecorator responseDecorator;
    private GetProjectActivitiesService getProjectActivitiesService;

    @PostMapping(path = "classroom/{classroomId}/project")
    public ResponseEntity<Long> newProject(@RequestBody ProjectNewDTO projectNewDTO, @PathVariable Long classroomId) {
        return responseDecorator.decorate(()->createProjectService.execute(projectNewDTO,classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}")
    public ResponseEntity< ProjectDTO> getProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(()-> getProjectService.execute(projectId));
    }

    @DeleteMapping(path = "classroom/{classroomId}/project/{projectId}")
    public ResponseEntity<Long> deleteProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(()->deleteProjectService.execute(projectId));
    }

    @PutMapping(path = "classroom/{classroomId}/project")
    public ResponseEntity<Long> updateProject(@RequestBody ProjectDTO projectDTO) {
        return responseDecorator.decorate(()->updateProjectService.execute(projectDTO));
    }


    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/students")
    public ResponseEntity< ArrayList<StudentDTO>> getProjectStudents(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(()-> getProjectStudentsService.execute(projectId));
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/add")
    public ResponseEntity<Long> addProjectStudents (@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId){
        return responseDecorator.decorate(()->addProjectStudentsService.execute(projectId, studentDTOs));
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/remove")
    public ResponseEntity<Long> removeProjectStudents (@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId){
        return responseDecorator.decorate(()->removeProjectStudentsService.execute(projectId, studentDTOs));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/activities")
    public ResponseEntity<ArrayList<ActivityDTO>> getProjectActivities(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(()-> getProjectActivitiesService.execute(projectId));
    }


}