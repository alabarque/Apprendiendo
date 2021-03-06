package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupProgressDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;
import com.proyecto.apprendiendo.services.general_services.group_services.*;
import com.proyecto.apprendiendo.services.general_services.group_student_services.AddGroupStudentService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.GetGroupStudentsService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.RemoveGroupStudentService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.UpdateGroupStudentService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class GroupController {

    private CreateGroupService createGroupService;
    private GetGroupService getGroupService;
    private DeleteGroupService deleteGroupService;
    private UpdateGroupService updateGroupService;
    private GetGroupStudentsService getGroupStudentsService;
    private AddGroupStudentService addGroupStudentService;
    private RemoveGroupStudentService removeGroupStudentService;
    private UpdateGroupStudentService updateGroupStudentService;
    private GetGroupProgressService getGroupProgressService;
    private UpdateGroupProgressService updateGroupProgressService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "group")
    public ResponseEntity<Long> newGroup(@RequestBody GroupDTO groupDTO) {
        return responseDecorator.decorate(() -> createGroupService.execute(groupDTO));
    }

    @GetMapping(path = "group/{groupId}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long groupId) {
        return responseDecorator.decorate(() -> getGroupService.execute(groupId));
    }

    @DeleteMapping(path = "group/{groupId}")
    public ResponseEntity<Long> deleteGroup(@PathVariable Long groupId) {
        return responseDecorator.decorate(() -> deleteGroupService.execute(groupId));
    }

    @PutMapping(path = "group")
    public ResponseEntity<Long> updateGroup(@RequestBody GroupDTO groupDTO) {
        return responseDecorator.decorate(() -> updateGroupService.execute(groupDTO));
    }

    @GetMapping(path = "group/{groupId}/students")
    public ResponseEntity<ArrayList<GroupStudentDTO>> getGroupStudents(@PathVariable("groupId") Long groupId) {
        return responseDecorator.decorate(() -> getGroupStudentsService.execute(groupId));
    }

    @GetMapping(path = "group/{groupId}/progress")
    public ResponseEntity<Double> getGroupProgress(@PathVariable("groupId") Long groupId) {
        return responseDecorator.decorate(() -> getGroupProgressService.execute(groupId));
     }

    @PutMapping(path = "group/{groupId}/progress")
    public ResponseEntity<Long> updateGroupProgress(@PathVariable("groupId") Long groupId, @RequestBody GroupProgressDTO groupProgressDTO) {
        return responseDecorator.decorate(() -> updateGroupProgressService.execute(groupId, groupProgressDTO));
    }

    @PostMapping(path = "group/{groupId}/student/{studentId}")
    public ResponseEntity<Long> addGroupStudents(@RequestBody GroupStudentDTO groupStudentDTO, @PathVariable("groupId") Long groupId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> addGroupStudentService.execute(groupId, studentId, groupStudentDTO.getGroupRole()));
    }

    @DeleteMapping(path = "group/{groupId}/student/{studentId}")
    public ResponseEntity<Long> removeGroupStudents(@PathVariable("groupId") Long groupId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> removeGroupStudentService.execute(groupId, studentId));
    }

    @PutMapping(path = "group/{groupId}/student/{studentId}")
    public ResponseEntity<Long> updateGroupStudent(@RequestBody GroupStudentDTO groupStudentDTO, @PathVariable("groupId") Long groupId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> updateGroupStudentService.execute(groupStudentDTO));
    }
}
