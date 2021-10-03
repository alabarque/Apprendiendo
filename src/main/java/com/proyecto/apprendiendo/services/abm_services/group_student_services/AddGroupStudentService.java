package com.proyecto.apprendiendo.services.abm_services.group_student_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.GroupStudent;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddGroupStudentService {

    private GroupStudentRepository groupStudentRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long groupId, Long studentId, String groupRole) {
        if (groupStudentRepository.findByStudentIdAndGroupId(studentId,groupId) == null){
            groupStudentRepository.save(GroupStudent.builder()
                                                    .groupId(groupId)
                                                    .studentId(studentId)
                                                    .groupRole(groupRole)
                                                    .build());
        }
        return groupId;
    }
}
