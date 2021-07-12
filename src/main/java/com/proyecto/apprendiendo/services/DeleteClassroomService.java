package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClassroomService {

    private ClassroomRepository classroomRepository;

    public void execute(Long clasroomId){
        classroomRepository.deleteById(clasroomId);
    }
}