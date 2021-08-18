package com.proyecto.apprendiendo.services.abm_services.classroom_services;

import com.proyecto.apprendiendo.entities.UserClassroom;
import com.proyecto.apprendiendo.entities.UserProject;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.UserClassroomRepository;
import com.proyecto.apprendiendo.repositories.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class UpdateClassroomStudentsService {

    private UserClassroomRepository userClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long classroomId, ArrayList<StudentDTO> studentDTOs){
        userClassroomRepository.deleteByClassroomId(classroomId);
        studentDTOs.forEach(s -> userClassroomRepository.save(UserClassroom.builder().classroomId(classroomId).userId(s.getId()).build()));
    }
}
