package com.proyecto.apprendiendo.services.general_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetClassroomStudentsProgressService {

    private StudentClassroomRepository studentClassroomRepository;
    private GetStudentClassroomProgressService getStudentClassroomProgressService;

    public ArrayList<StudentClassroomDTO> execute(Long classroomId) {
        ArrayList<StudentClassroom> classroomStudents = studentClassroomRepository.findByClassroomId(classroomId);
        return classroomStudents.stream()
                                .map(ps -> getStudentClassroomProgressService.execute(ps.getStudentId(), classroomId))
                                .collect(Collectors.toCollection(ArrayList::new));
    }
}
