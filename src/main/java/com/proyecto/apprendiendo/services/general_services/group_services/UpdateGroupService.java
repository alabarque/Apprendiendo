package com.proyecto.apprendiendo.services.general_services.group_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UpdateGroupService {

    private GroupRepository groupRepository;

    public Long execute(GroupDTO groupDTO) {
        Group group = groupRepository.getById(groupDTO.getId());
        group.setName(groupDTO.getName());
        groupRepository.save(group);
        return groupDTO.getId();
    }
}
