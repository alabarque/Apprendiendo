package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAvatarService {

    private ClassroomRepository classroomRepository;

    public void execute(ClassroomDTO classroomDTO) {
        Classroom classroom = Classroom.builder().name(classroomDTO.getName()).teacherId(classroomDTO.getTeacherId()).build();
        classroomRepository.save(classroom);
    }
}
