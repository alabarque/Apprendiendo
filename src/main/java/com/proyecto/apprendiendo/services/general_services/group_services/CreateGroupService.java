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
public class CreateGroupService {

    private GroupRepository groupRepository;

    public Long execute(GroupDTO groupDTO) {
        Group group = Group.builder()
                           .name(groupDTO.getName())
                           .projectId(groupDTO.getProjectId())
                           .build();

        return groupRepository.save(group).getId();
    }
}
