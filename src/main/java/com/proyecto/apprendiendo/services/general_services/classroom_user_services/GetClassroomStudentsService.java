package com.proyecto.apprendiendo.services.general_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.UserRepository;
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

    private StudentClassroomRepository studentClassroomRepository;
    private UserRepository userRepository;

    public ArrayList<StudentDTO> execute(Long classroomId) {
        ArrayList<StudentClassroom> classroomStudents = studentClassroomRepository.findByClassroomId(classroomId);
        return classroomStudents.stream()
                                .map(ps -> StudentMapper.entityToDto(userRepository.getById(ps.getStudentId())))
                                .collect(Collectors.toCollection(ArrayList::new));
    }
}
