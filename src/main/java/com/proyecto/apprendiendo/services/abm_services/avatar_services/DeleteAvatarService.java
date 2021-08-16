package com.proyecto.apprendiendo.services.abm_services.avatar_services;

import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAvatarService {

    private ClassroomRepository classroomRepository;

    public void execute(Long clasroomId){
        classroomRepository.deleteById(clasroomId);
    }
}
