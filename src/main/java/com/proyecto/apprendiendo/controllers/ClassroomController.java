package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.classroom_services.*;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.AddClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.RemoveClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetSubRewardsService;
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
    private RemoveClassroomStudentsService removeClassroomStudentsService;
    private GetClassroomProjectsService getClassroomProjectsService;
    private ResponseDecorator responseDecorator;
    private GetClassroomStudentsProgressService getClassroomStudentsProgressService;
    private GetSourcesDocumentsService getSourcesDocumentsService;
    private GetTargetRewardsService getTargetRewardsService;
    private GetTargetSubRewardsService getTargetSubRewardsService;

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
        return responseDecorator.decorate(() -> deleteClassroomService.execute(classroomId));
    }

    @PutMapping(path = "classroom")
    public ResponseEntity<Long> updateClassroom(@RequestBody ClassroomDTO classroomDTO) {
        return responseDecorator.decorate(() -> updateClassroomService.execute(classroomDTO));
    }

    @GetMapping(path = "classroom/{classroomId}/students")
    public ResponseEntity<ArrayList<StudentDTO>> getClassroomStudents(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getClassroomStudentsService.execute(classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getClassroomDocuments(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getClassroomDocumentsSummary(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(classroomId, "SUMMARY"));
    }

    @GetMapping(path = "classroom/{classroomId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getClassroomDocumentsSelective(@PathVariable("classroomId") Long classroomId, @RequestParam(required = false) String type) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(classroomId, "SELECTIVE", type));
    }

    @GetMapping(path = "classroom/{classroomId}/students/progress")
    public ResponseEntity<ArrayList<StudentClassroomDTO>> getClassroomStudentsProgress(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getClassroomStudentsProgressService.execute(classroomId));
    }

    @PostMapping(path = "classroom/{classroomId}/student/{studentId}")
    public ResponseEntity<Long> addClassroomStudent(@PathVariable("classroomId") Long classroomId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> addClassroomStudentsService.execute(classroomId, studentId));
    }

    @DeleteMapping(path = "classroom/{classroomId}/student/{studentId}")
    public ResponseEntity<Long> removeClassroomStudent(@PathVariable("classroomId") Long classroomId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> removeClassroomStudentsService.execute(classroomId, studentId));
    }

    @GetMapping(path = "classroom/{classroomId}/projects")
    public ResponseEntity<ArrayList<ProjectDTO>> getClassroomProjects(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getClassroomProjectsService.execute(classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getClassroomRewards(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getTargetRewardsService.execute(classroomId));
    }

    @GetMapping(path = "classroom/{classroomId}/rewards/all")
    public ResponseEntity<ArrayList<RewardDTO>> getClassroomSubRewards(@PathVariable("classroomId") Long classroomId) {
        return responseDecorator.decorate(() -> getTargetSubRewardsService.execute(classroomId, "CLASSROOM"));
    }
}
