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
public class CreateClassroomService {

    private ClassroomRepository classroomRepository;

    public Long execute(ClassroomDTO classroomDTO) {
        Classroom classroom = Classroom.builder().name(classroomDTO.getName()).teacherId(classroomDTO.getTeacherId()).division(classroomDTO.getDivision()).subject(classroomDTO.getSubject()).year(classroomDTO.getYear()).build();
        return classroomRepository.save(classroom).getId();
    }
}
