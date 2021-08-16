package com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAvatarBodyPartService {

    private ClassroomRepository classroomRepository;

    public ClassroomDTO execute(Long idClass) {
        Classroom classroom = classroomRepository.getById(idClass);
        return ClassroomMapper.entityToDto(classroom);
    }
}
