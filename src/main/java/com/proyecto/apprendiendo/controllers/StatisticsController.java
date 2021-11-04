package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.StatisticDTO;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetActivitiesStatisticsService;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetClassroomsStatisticsService;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetProjectsStatisticsService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class StatisticsController {

    private ResponseDecorator responseDecorator;
    private GetActivitiesStatisticsService getActivitiesStatisticsService;
    private GetClassroomsStatisticsService getClassroomsStatisticsService;
    private GetProjectsStatisticsService getProjectsStatisticsService;

    @GetMapping(path = "statistics/teacher/{teacherId}/classrooms")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherClassroomsStatistics(@PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getClassroomsStatisticsService.execute(teacherId));
    }

    @GetMapping(path = "statistics/teacher/{teacherId}/projects")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherProjectsStatistics(@PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getProjectsStatisticsService.execute(teacherId,"TEACHER"));
    }

    @GetMapping(path = "statistics/teacher/{teacherId}/lessons")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherLessonsStatistics(@PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(teacherId,"TEACHER", "LESSON"));
    }

    @GetMapping(path = "statistics/teacher/{teacherId}/activities")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherActivitiesStatistics(@PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(teacherId,"TEACHER", "ACTIVITY"));
    }

    @GetMapping(path = "statistics/teacher/{teacherId}/students")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherStudentsStatistics(@PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(teacherId,"TEACHER", "STUDENT"));
    }

    @GetMapping(path = "statistics/classroom/{classroomId}/projects")
    public ResponseEntity<ArrayList<StatisticDTO>> getClassroomProjectsStatistics(@PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getProjectsStatisticsService.execute(classroomId,"CLASSROOM"));
    }

    @GetMapping(path = "statistics/classroom/{classroomId}/lessons")
    public ResponseEntity<ArrayList<StatisticDTO>> getClassroomLessonsStatistics(@PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(classroomId,"CLASSROOM", "LESSON"));
    }

    @GetMapping(path = "statistics/classroom/{classroomId}/activities")
    public ResponseEntity<ArrayList<StatisticDTO>> getClassroomActivitiesStatistics(@PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(classroomId,"CLASSROOM", "ACTIVITY"));
    }

    @GetMapping(path = "statistics/classroom/{classroomId}/students")
    public ResponseEntity<ArrayList<StatisticDTO>> getClassroomStudentsStatistics(@PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(classroomId,"CLASSROOM", "STUDENT"));
    }

    @GetMapping(path = "statistics/project/{projectId}/lessons")
    public ResponseEntity<ArrayList<StatisticDTO>> getProjectLessonsStatistics(@PathVariable Long projectId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(projectId,"PROJECT", "LESSON"));
    }

    @GetMapping(path = "statistics/project/{projectId}/activities")
    public ResponseEntity<ArrayList<StatisticDTO>> getProjectActivitiesStatistics(@PathVariable Long projectId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(projectId,"PROJECT", "ACTIVITY"));
    }

    @GetMapping(path = "statistics/project/{projectId}/students")
    public ResponseEntity<ArrayList<StatisticDTO>> getProjectStudentsStatistics(@PathVariable Long projectId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(projectId,"PROJECT", "STUDENT"));
    }

    @GetMapping(path = "statistics/lesson/{lessonId}/activities")
    public ResponseEntity<ArrayList<StatisticDTO>> getLessonActivitiesStatistics(@PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(lessonId,"LESSON", "ACTIVITY"));
    }

    @GetMapping(path = "statistics/lesson/{lessonId}/students")
    public ResponseEntity<ArrayList<StatisticDTO>> getLessonStudentsStatistics(@PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> getActivitiesStatisticsService.execute(lessonId,"LESSON", "STUDENT"));
    }

}
