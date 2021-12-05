package com.proyecto.apprendiendo.services.general_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.reward_services.AutomaticRewardGrantingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;
    private AutomaticRewardGrantingService automaticRewardGrantingService;
    private AddProjectStudentsService addProjectStudentsService;
    private GetProjectService getProjectService;

    public Long execute(Long studentId, Long projectId, StudentProjectDTO studentProjectDTO) {
        StudentProject studentProject = studentProjectRepository.findByStudentIdAndProjectId(studentId, projectId);
        if (studentProject == null) {
            addProjectStudentsService.execute(projectId, studentId);
            studentProject = studentProjectRepository.findByStudentIdAndProjectId(studentId, projectId);
        }
        studentProject.setGrade(studentProjectDTO.getGrade());
        studentProject.setPercentageCompleted(studentProjectDTO.getPercentageCompleted());
        studentProject.setDateCompleted(studentProjectDTO.getDateCompleted());
        if (studentProject.getPercentageCompleted() == 100.00 & studentProject.getDateCompleted() == null) studentProject.setDateCompleted(LocalDateTime.now());
        studentProjectRepository.save(studentProject);

        automaticRewardGrantingService.execute(studentId, projectId, "PROJECT");
        automaticRewardGrantingService.execute(studentId, getProjectService.execute(projectId).getClassroomId(), "CLASSROOM");
        return studentProjectDTO.getId();
    }
}
