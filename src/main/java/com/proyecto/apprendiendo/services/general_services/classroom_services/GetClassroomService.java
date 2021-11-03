package com.proyecto.apprendiendo.services.general_services.classroom_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetClassroomService {

    private ClassroomRepository classroomRepository;

    public ClassroomDTO execute(Long idClass) {
        Classroom classroom = classroomRepository.getById(idClass);
        return ClassroomMapper.entityToDto(classroom);
    }
}
