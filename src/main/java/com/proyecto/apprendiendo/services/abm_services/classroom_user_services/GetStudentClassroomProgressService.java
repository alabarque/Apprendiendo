package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.mappers.StudentClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentClassroomProgressService {

    private StudentClassroomRepository studentClassroomRepository;

    public StudentClassroomDTO execute(Long studentId, Long classroomId){
        return StudentClassroomMapper.entityToDto(studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId));

    }
}
