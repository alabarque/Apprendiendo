package com.proyecto.apprendiendo.services.general_services.group_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.services.mappers.GroupMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class GetGroupService {

    private GroupRepository groupRepository;
    private GetGroupProgressService getGroupProgressService;

    public GroupDTO execute(Long idClass) {
        Group group = groupRepository.getById(idClass);
        GroupDTO dto = GroupMapper.entityToDto(group);
        dto.setProgress(getGroupProgressService.execute(idClass));
        return dto;
    }
}
