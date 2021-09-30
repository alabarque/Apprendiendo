package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.enums.UserRole;
import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class GetUserClassroomsService {

    private UserRepository userRepository;
    private GetTeacherClassroomsService getTeacherClassroomsService;
    private GetStudentClassroomsService getStudentClassroomsService;

    public ArrayList<ClassroomDTO> execute(Long userId) {
        String userRole = userRepository.getById(userId).getRole();

        if(userRole.equals(UserRole.ROLE_STUDENT.getValue())) return getStudentClassroomsService.execute(userId);
        else if(userRole.equals(UserRole.ROLE_TEACHER.getValue())) return getTeacherClassroomsService.execute(userId);
        else throw new RuntimeException("Error, solo los estudiantes y los docentes tienen classrooms");
    }
}
