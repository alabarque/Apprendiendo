package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class ABMClassroomController {

    private CreateClassroomService createClassroomService;
    private GetClassroomService getClassroomService;
    private DeleteClassroomService deleteClassroomService;
    private UpdateClassroomService updateClassroomService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private UpdateClassroomStudentsService updateClassroomStudentsService;

    @PostMapping(path = "classroom")
    public void newClassroom(@RequestBody ClassroomDTO classroomDTO) {
        createClassroomService.execute(classroomDTO);
    }

    @GetMapping(path = "classroom/{classroomId}")
    public ClassroomDTO getClassroom(@PathVariable Long classroomId) {
        return getClassroomService.execute(classroomId);
    }

    @DeleteMapping(path = "classroom/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId) {
        deleteClassroomService.execute(classroomId);
    }

    @PutMapping(path = "classroom")
    public void updateClassroom(@RequestBody ClassroomDTO classroomDTO) {
        updateClassroomService.execute(classroomDTO);
    }

    @GetMapping(path = "classroom/{classroomId}/students")
    public ArrayList<StudentDTO> getProjectStudents(@PathVariable("classroomId") Long classroomId) {
        return getClassroomStudentsService.execute(classroomId);
    }

    @PutMapping(path = "classroom/{classroomId}/students")
    public void updateProjectStudents(@RequestBody ArrayList<StudentDTO> studentDTOs, @PathVariable("classroomId") Long classroomId) {
        updateClassroomStudentsService.execute(classroomId, studentDTOs);
    }
}
