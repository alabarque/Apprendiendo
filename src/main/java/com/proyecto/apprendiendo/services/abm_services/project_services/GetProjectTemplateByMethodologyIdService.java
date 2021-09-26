package com.proyecto.apprendiendo.services.abm_services.project_services;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ActivityTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.LessonTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.mappers.ActivityMapper;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import com.proyecto.apprendiendo.services.mappers.LessonMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectTemplateByMethodologyIdService {

    private ProjectRepository projectRepository;
    private GetProjectTemplateService getProjectTemplateService;

    public ProjectTemplateDTO execute(Long methodologyId) {
        return getProjectTemplateService.execute(projectRepository.findByClassroomIdAndMethodologyId(Long.parseLong("0"), methodologyId).getId());
    }
}
