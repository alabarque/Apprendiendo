package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateClassroomService {

    private ClassroomRepository classroomRepository;

    public void execute(ClassroomDTO classroomDTO){
        Classroom classroom = classroomRepository.getById(classroomDTO.getId());
        classroom.setId(classroomDTO.getId());
        classroom.setName(classroomDTO.getName());
        classroom.setTeacherId(classroomDTO.getTeacherId());
        classroom.setTeacherName(classroomDTO.getTeacherName());
        classroomRepository.save(classroom);
    }
}