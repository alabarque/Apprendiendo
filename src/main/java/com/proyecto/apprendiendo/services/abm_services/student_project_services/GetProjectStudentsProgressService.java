package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectStudentsProgressService {

    private GetStudentProjectProgressService getStudentProjectProgressService;
    private ProjectRepository projectRepository;
    private GetClassroomStudentsService getClassroomStudentsService;

    public ArrayList<StudentProjectDTO> execute(Long projectId) {
        Project project = projectRepository.getById(projectId);
        return getClassroomStudentsService.execute(project.getClassroomId())
                                          .stream()
                                          .map(s -> getStudentProjectProgressService.execute(s.getId(), projectId))
                                          .collect(Collectors.toCollection(ArrayList::new));
    }
}
