package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.*;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.AddClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.RemoveProjectStudentsService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ClassroomController {

    private CreateClassroomService createClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private AddClassroomStudentsService addClassroomStudentsService;
    private RemoveProjectStudentsService removeProjectStudentsService;
    private GetClassroomProjectsService getClassroomProjectsService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "classroom")
    public ResponseEntity<Long> newClassroom(@RequestBody ClassroomDTO classroomDTO) {
        return responseDecorator.decorate(() -> createClassroomService.execute(classroomDTO));
    }

    @GetMapping(path = "classroom/{classroomId}")
    public ResponseEntity<ClassroomDTO> getClassroom(@PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getClassroomService.execute(classroomId));
    }

    @DeleteMapping(path = "classroom/{classroomId}")
    public ResponseEntity<Long> deleteClassroom(@PathVariable Long classroomId) {
        return responseDecorator.decorate(()->deleteClassroomService.execute(classroomId));
    }

    @PutMapping(path = "classroom")
    public ResponseEntity<Long> updateClassroom(@RequestBody ClassroomDTO classroomDTO) {
        return responseDecorator.decorate(()->updateClassroomService.execute(classroomDTO));
    }

    @GetMapping(path = "classroom/{classroomId}/students")
    public ResponseEntity< ArrayList<StudentDTO> > getProjectStudents(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(()->getClassroomStudentsService.execute(classroomId));
    }

    @PutMapping(path = "classroom/{classroomId}/students/add")
    public ResponseEntity<Long> addProjectStudents(@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(()->addClassroomStudentsService.execute(classroomId, studentDTOs));
    }

    @PutMapping(path = "classroom/{classroomId}/students/remove")
    public ResponseEntity<Long> removeProjectStudents(@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(()->removeProjectStudentsService.execute(classroomId, studentDTOs));
    }

    @GetMapping(path = "classroom/{classroomId}/projects")
    public ResponseEntity< ArrayList<ProjectDTO> > getClassroomProjects (@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(()->getClassroomProjectsService.execute(classroomId));
    }
}
