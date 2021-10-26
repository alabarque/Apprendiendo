package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.GetProjectStudentGroupService;
import com.proyecto.apprendiendo.services.general_services.project_services.*;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetSubRewardsService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetProjectStudentsProgressService;
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
    private ResponseDecorator responseDecorator;
    private GetProjectLessonsService getProjectLessonsService;
    private CreateProjectFromTemplateService createProjectFromTemplateService;
    private GetProjectTemplateService getProjectTemplateService;
    private GetProjectStudentsProgressService getProjectStudentsProgressService;
    private GetSourcesDocumentsService getSourcesDocumentsService;
    private GetProjectGroupsService getProjectGroupsService;
    private GetTargetRewardsService getTargetRewardsService;
    private GetProjectStudentGroupService getProjectStudentGroupService;
    private GetTargetSubRewardsService getTargetSubRewardsService;

    @PostMapping(path = "project")
    public ResponseEntity<Long> newProject(@RequestBody ProjectDTO projectDTO) {
        return responseDecorator.decorate(() -> createProjectService.execute(projectDTO));
    }

    @GetMapping(path = "project/{projectId}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectService.execute(projectId));
    }

    @GetMapping(path = "project/{projectId}/template")
    public ResponseEntity<ProjectTemplateDTO> getProjectAsTemplate(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectTemplateService.execute(projectId));
    }

    @DeleteMapping(path = "project/{projectId}")
    public ResponseEntity<Long> deleteProject(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> deleteProjectService.execute(projectId));
    }

    @PutMapping(path = "project")
    public ResponseEntity<Long> updateProject(@RequestBody ProjectDTO projectDTO) {
        return responseDecorator.decorate(() -> updateProjectService.execute(projectDTO));
    }

    @GetMapping(path = "project/{projectId}/documents")
    public ResponseEntity<ArrayList<DocumentDTO>> getProjectDocuments(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(projectId));
    }

    @GetMapping(path = "project/{projectId}/documents/summary")
    public ResponseEntity<ArrayList<DocumentDTO>> getProjectDocumentsSummary(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(projectId, "SUMMARY"));
    }

    @GetMapping(path = "project/{projectId}/documents/selective")
    public ResponseEntity<ArrayList<DocumentDTO>> getProjectDocumentsSelective(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getSourcesDocumentsService.execute(projectId, "SELECTIVE"));
    }

    @GetMapping(path = "project/{projectId}/students/progress")
    public ResponseEntity<ArrayList<StudentProjectDTO>> getProjectStudentsProgress(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectStudentsProgressService.execute(projectId));
    }

    @GetMapping(path = "project/{projectId}/lessons")
    public ResponseEntity<ArrayList<LessonDTO>> getProjectLessons(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectLessonsService.execute(projectId));
    }

    @PostMapping(path = "project/template")
    public ResponseEntity<Long> newProjectFromTemplate(@RequestBody ProjectTemplateDTO projectTemplateDTO) {
        return responseDecorator.decorate(() -> createProjectFromTemplateService.execute(projectTemplateDTO));
    }

    @GetMapping(path = "project/{projectId}/groups")
    public ResponseEntity<ArrayList<GroupDTO>> getProjectGroups(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getProjectGroupsService.execute(projectId));
    }

    @GetMapping(path = "project/{projectId}/groups/student/{studentId}")
    public ResponseEntity<GroupDTO> getProjectStudentGroup(@PathVariable("projectId") Long projectId, @PathVariable("studentId") Long studentId) {
        return responseDecorator.decorate(() -> getProjectStudentGroupService.execute(projectId,studentId));
    }

    @GetMapping(path = "project/{projectId}/rewards")
    public ResponseEntity<ArrayList<RewardDTO>> getProjectRewards(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getTargetRewardsService.execute(projectId));
    }

    @GetMapping(path = "project/{projectId}/rewards/all")
    public ResponseEntity<ArrayList<RewardDTO>> getProjectSubRewards(@PathVariable("projectId") Long projectId) {
        return responseDecorator.decorate(() -> getTargetSubRewardsService.execute(projectId, "PROJECT"));
    }

}