package com.proyecto.apprendiendo.services.abm_services.group_student_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.GroupStudent;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateGroupStudentService {

    private GroupStudentRepository groupStudentRepository;

    public Long execute(GroupStudentDTO groupStudentDTO) {
        GroupStudent groupStudent = groupStudentRepository.getById(groupStudentDTO.getId());
        groupStudent.setGroupRole(groupStudentDTO.getGroupRole());
        groupStudentRepository.save(groupStudent);
        return groupStudentDTO.getId();
    }
}
