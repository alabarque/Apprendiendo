package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.abm_services.project_services.*;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.AddProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetProjectStudentsProgressService;
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
    private GetProjectLessonsService getProjectLessonsService;
    private CreateProjectFromTemplateService createProjectFromTemplateService;
    private GetProjectTemplateService getProjectTemplateService;
    private GetProjectStudentsProgressService getProjectStudentsProgressService;

    @PostMapping(path = "classroom/{classroomId}/project")
    public ResponseEntity<Long> newProject(@RequestBody ProjectNewDTO projectNewDTO, @PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> createProjectService.execute(projectNewDTO, classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectService.execute(projectId));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/template")
    public ResponseEntity<ProjectTemplateDTO> getProjectAsTemplate(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectTemplateService.execute(projectId));
    }

    @DeleteMapping(path = "classroom/{classroomId}/project/{projectId}")
    public ResponseEntity<Long> deleteProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> deleteProjectService.execute(projectId));
    }

    @PutMapping(path = "classroom/{classroomId}/project")
    public ResponseEntity<Long> updateProject(@RequestBody ProjectDTO projectDTO) {
        return responseDecorator.decorate(() -> updateProjectService.execute(projectDTO));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/students")
    public ResponseEntity<ArrayList<StudentDTO>> getProjectStudents(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectStudentsService.execute(projectId));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/students/progress")
    public ResponseEntity<ArrayList<StudentProjectDTO>> getProjectStudentsProgress(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectStudentsProgressService.execute(projectId));
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/add")
    public ResponseEntity<Long> addProjectStudents(@RequestBody Long studentId, @PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> addProjectStudentsService.execute(projectId, studentId));
    }

    @PutMapping(path = "classroom/{classroomId}/project/{projectId}/students/remove")
    public ResponseEntity<Long> removeProjectStudents(@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> removeProjectStudentsService.execute(projectId, studentDTOs));
    }

    @GetMapping(path = "classroom/{classroomId}/project/{projectId}/lessons")
    public ResponseEntity<ArrayList<LessonDTO>> getProjectLessons(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectLessonsService.execute(projectId));
    }

    @PostMapping(path = "classroom/{classroomId}/project/template")
    public ResponseEntity<Long> newProjectFromTemplate(@RequestBody ProjectTemplateDTO projectTemplateDTO, @PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> createProjectFromTemplateService.execute(projectTemplateDTO, classroomId));
    }


}