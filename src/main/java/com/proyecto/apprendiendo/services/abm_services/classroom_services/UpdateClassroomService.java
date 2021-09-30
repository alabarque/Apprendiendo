package com.proyecto.apprendiendo.services.abm_services.classroom_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateClassroomService {

    private ClassroomRepository classroomRepository;

    public Long execute(ClassroomDTO classroomDTO) {
        Classroom classroom = classroomRepository.getById(classroomDTO.getId());
        classroom.setId(classroomDTO.getId());
        //classroom.setName(classroomDTO.getName());
        classroom.setTeacherId(classroomDTO.getTeacherId());
        classroomRepository.save(classroom);
        return classroomDTO.getId();
    }
}
