package com.proyecto.apprendiendo.services.abm_services.classroom_services;

import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteClassroomService {

    private ClassroomRepository classroomRepository;

    public Long execute(Long classroomId) {
        classroomRepository.deleteById(classroomId);
        return classroomId;
    }
}
