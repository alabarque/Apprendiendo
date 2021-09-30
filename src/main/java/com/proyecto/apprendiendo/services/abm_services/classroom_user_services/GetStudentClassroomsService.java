package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.services.mappers.ClassroomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentClassroomsService {

    private ClassroomRepository classroomRepository;
    private StudentClassroomRepository studentClassroomRepository;

    public ArrayList<ClassroomDTO> execute(Long studentId) {
        ArrayList<StudentClassroom> studentClassrooms = studentClassroomRepository.findByStudentId(studentId);
        return studentClassrooms.stream()
                                .map(ps -> ClassroomMapper.entityToDto(classroomRepository.getById(ps.getClassroomId())))
                                .collect(Collectors.toCollection(ArrayList::new));
    }
}
