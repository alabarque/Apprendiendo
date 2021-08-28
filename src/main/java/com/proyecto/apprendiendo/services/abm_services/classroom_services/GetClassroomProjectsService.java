package com.proyecto.apprendiendo.services.abm_services.classroom_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetClassroomProjectsService {

    private ProjectRepository projectRepository;

    public ArrayList<ProjectDTO> execute(Long idClass) {
        return projectRepository.findByClassroomId(idClass).stream().map(p -> ProjectMapper.entityToDto(p)).collect(Collectors.toCollection(ArrayList:: new));
    }
}
