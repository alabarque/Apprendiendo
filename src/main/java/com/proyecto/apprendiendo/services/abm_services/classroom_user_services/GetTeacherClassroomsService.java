package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetTeacherClassroomsService {

    private ClassroomRepository classroomRepository;

    public ArrayList<ClassroomDTO> execute(Long teacherId) {
        ArrayList<Classroom> teacherClassrooms = classroomRepository.findByTeacherId(teacherId);
        return teacherClassrooms.stream().map(c -> ClassroomMapper.entityToDto(c)).collect(Collectors.toCollection(ArrayList::new));
    }
}
