package com.proyecto.apprendiendo.services.general_services.group_student_services;

import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RemoveGroupStudentService {

    private GroupStudentRepository groupStudentRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long execute(Long groupId, Long studentId) {
        groupStudentRepository.deleteByStudentIdAndGroupId(studentId, groupId);
        return groupId;
    }
}
