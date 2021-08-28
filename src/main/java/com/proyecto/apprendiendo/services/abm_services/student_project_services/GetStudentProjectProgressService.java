package com.proyecto.apprendiendo.services.abm_services.student_project_services;

import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentActivityDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.mappers.StudentActivityMapper;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentProjectProgressService {

    private StudentProjectRepository studentProjectRepository;

    public StudentProjectDTO execute(Long studentId, Long activityId){
        return StudentProjectMapper.entityToDto(studentProjectRepository.findByUserIdAndProjectId(studentId, activityId));

    }
}
