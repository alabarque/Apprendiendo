package com.proyecto.apprendiendo.services.document_source_services;

import com.proyecto.apprendiendo.entities.UserClassroom;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.UserClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class AddDocumentSourcesService {

    parivate UserClassroomRepository userClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long classroomId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> userClassroomRepository.save(UserClassroom.builder().classroomId(classroomId).userId(s.getId()).build()));
    }
}
