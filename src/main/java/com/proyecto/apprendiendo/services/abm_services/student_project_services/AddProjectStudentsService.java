package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddProjectStudentsService {

    private StudentProjectRepository studentProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long projectId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> studentProjectRepository.save(StudentProject
                                                                    .builder().projectId(projectId).userId(s.getId()).hasAchievement(false).percentageCompleted(0.00).build()));
        return projectId;
    }
}
