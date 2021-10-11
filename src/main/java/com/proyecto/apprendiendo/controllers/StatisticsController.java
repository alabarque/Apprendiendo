package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.StatisticDTO;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetStatisticsService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class StatisticsController {

    private ResponseDecorator responseDecorator;
    private GetStatisticsService getStatisticsService;

    @GetMapping(path = "statistics/project/{projectId}")
    public ResponseEntity<ArrayList<StatisticDTO>> getProjectStatistics(@RequestParam String resultType, @PathVariable Long projectId) {
        return responseDecorator.decorate(() -> getStatisticsService.execute(projectId,"PROJECT", resultType));
    }

    @GetMapping(path = "statistics/classroom/{classroomId}")
    public ResponseEntity<ArrayList<StatisticDTO>> getClassroomStatistics(@RequestParam String resultType, @PathVariable Long classroomId) {
        return responseDecorator.decorate(() -> getStatisticsService.execute(classroomId,"CLASSROOM", resultType));
    }

    @GetMapping(path = "statistics/lesson/{lessonId}")
    public ResponseEntity<ArrayList<StatisticDTO>> getLessonStatistics(@RequestParam String resultType, @PathVariable Long lessonId) {
        return responseDecorator.decorate(() -> getStatisticsService.execute(lessonId,"LESSON", resultType));
    }

    @GetMapping(path = "statistics/teacher/{teacherId}")
    public ResponseEntity<ArrayList<StatisticDTO>> getTeacherStatistics(@RequestParam String resultType, @PathVariable Long teacherId) {
        return responseDecorator.decorate(() -> getStatisticsService.execute(teacherId,"TEACHER", resultType));
    }

}
