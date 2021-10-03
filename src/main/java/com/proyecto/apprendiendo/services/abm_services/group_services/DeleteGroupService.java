package com.proyecto.apprendiendo.services.abm_services.group_services;

import com.proyecto.apprendiendo.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DeleteGroupService {

    private GroupRepository groupRepository;

    public Long execute(Long groupId) {
        groupRepository.deleteById(groupId);
        return groupId;
    }
}
