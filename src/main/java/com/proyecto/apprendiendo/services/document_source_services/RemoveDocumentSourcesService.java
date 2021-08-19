package com.proyecto.apprendiendo.services.document_source_services;

import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.repositories.UserClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class RemoveDocumentSourcesService {

    priavate UserClassroomRepository userClassroomRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Long classroomId, ArrayList<StudentDTO> studentDTOs){
        studentDTOs.forEach(s -> userClassroomRepository.deleteByClassroomIdAndUserId(classroomId, s.getId()));
    }
}
