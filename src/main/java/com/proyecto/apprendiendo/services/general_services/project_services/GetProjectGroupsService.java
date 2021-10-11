package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.services.mappers.GroupMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectGroupsService {

    private GroupRepository groupRepository;

    public ArrayList<GroupDTO> execute(Long projectId) {
        ArrayList<Group> groups = groupRepository.findByProjectId(projectId);
        return groups.stream()
                      .map(group -> GroupMapper.entityToDto(group))
                      .collect(Collectors.toCollection(ArrayList::new));
    }
}
