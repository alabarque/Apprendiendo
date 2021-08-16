package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAvatarBodyPartService {

    private ClassroomRepository classroomRepository;

    public void execute(ClassroomDTO classroomDTO) {
        Classroom classroom = Classroom.builder().name(classroomDTO.getName()).teacherId(classroomDTO.getTeacherId()).build();
        classroomRepository.save(classroom);
    }
}
