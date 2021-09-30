package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.reward_services.AutomaticRewardGrantingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;
    private AutomaticRewardGrantingService automaticRewardGrantingService;
    private AddProjectStudentsService addProjectStudentsService;

    public Long execute(Long studentId, Long projectId, StudentProjectDTO studentProjectDTO){
        StudentProject studentProject = studentProjectRepository.findByUserIdAndProjectId(studentId, projectId);
        if(studentProject == null) {
            addProjectStudentsService.execute(projectId,studentId);
            studentProject = studentProjectRepository.findByUserIdAndProjectId(studentId, projectId);
        }
        studentProject.setGrade(studentProjectDTO.getGrade());
        studentProject.setPercentageCompleted(studentProjectDTO.getPercentageCompleted());
        studentProject.setDateCompleted(studentProjectDTO.getDateCompleted());
        studentProjectRepository.save(studentProject);
        automaticRewardGrantingService.execute(studentId, projectId, "PROJECT");
        return studentProjectDTO.getId();
    }
}
