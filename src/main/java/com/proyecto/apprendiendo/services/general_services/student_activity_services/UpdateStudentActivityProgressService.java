package com.proyecto.apprendiendo.services.general_services.student_activity_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.reward_services.AutomaticRewardGrantingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentActivityProgressService {

    private StudentActivityRepository studentActivityRepository;
    private AutomaticRewardGrantingService automaticRewardGrantingService;
    private GetProjectService getProjectService;
    private GetActivityService getActivityService;
    private GetLessonService getLessonService;

    public Long execute(Long studentId, Long activityId, StudentActivityDTO studentActivityDTO) {
        StudentActivity studentActivity = studentActivityRepository.findByStudentIdAndActivityId(studentId, activityId);

        if (studentActivity == null) {
            studentActivity = studentActivityRepository.save(StudentActivity.builder()
                                                          .activityId(activityId)
                                                          .studentId(studentId)
                                                          .grade(studentActivityDTO.getGrade())
                                                          .percentageCompleted(studentActivityDTO.getPercentageCompleted())
                                                          .dateCompleted(dateCompleted(studentActivityDTO))
                                                          .build());
        }
        else {
            studentActivity.setGrade(studentActivityDTO.getGrade());
            studentActivity.setPercentageCompleted(studentActivityDTO.getPercentageCompleted());
            studentActivity.setDateCompleted(dateCompleted(studentActivityDTO));
            studentActivityRepository.save(studentActivity);
        }

        automaticRewardGrantingService.execute(studentId, activityId, "ACTIVITY");
        automaticRewardGrantingService.execute(studentId, getLessonService.execute(getActivityService.execute(activityId).getLessonId()).getProjectId(), "PROJECT");
        automaticRewardGrantingService.execute(studentId, getProjectService.execute(getLessonService.execute(getActivityService.execute(activityId).getLessonId()).getProjectId()).getClassroomId(), "CLASSROOM");

        return studentActivityDTO.getId();
    }

    LocalDateTime dateCompleted(StudentActivityDTO studentActivityDTO) {
        if(studentActivityDTO.getPercentageCompleted() != null){
            if(studentActivityDTO.getPercentageCompleted().equals(100.00)) {
                if(studentActivityDTO.getDateCompleted() == null) return LocalDateTime.now();
                else return studentActivityDTO.getDateCompleted();
            }
        }
        return null;
    }
}


