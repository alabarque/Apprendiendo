package com.proyecto.apprendiendo.services.abm_services.project_user_services;

import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveProjectStudentsService {

    private UserProjectRepository userProjectRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long projectId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> userProjectRepository.deleteByProjectIdAndUserId(projectId,s.getId()));
    }
}
