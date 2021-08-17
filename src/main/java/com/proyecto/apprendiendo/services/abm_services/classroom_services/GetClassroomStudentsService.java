package com.proyecto.apprendiendo.services.abm_services.classroom_services;

import com.proyecto.apprendiendo.entities.UserClassroom;
import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.mappers.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetClassroomStudentsService {

    private ClassroomRepository classroomRepository;
    private UserClassroomRepository userClassroomRepository;
    private UserRepository userRepository;

    public ArrayList<StudentDTO> execute(Long classroomId) {
        ArrayList<UserClassroom> classroomStudents = userClassroomRepository.findByClassroomId(classroomId);
        return classroomStudents.stream().map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getUserId()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
