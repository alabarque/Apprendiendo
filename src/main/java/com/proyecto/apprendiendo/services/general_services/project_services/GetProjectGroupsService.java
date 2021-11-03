package com.proyecto.apprendiendo.services.general_services.project_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.services.general_services.group_services.GetGroupProgressService;
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
    private GetGroupProgressService getGroupProgressService;

    public ArrayList<GroupDTO> execute(Long projectId) {
        ArrayList<Group> groups = groupRepository.findByProjectId(projectId);
        return groups.stream()
                      .map(group -> {
                          GroupDTO dto = GroupMapper.entityToDto(group);
                          dto.setProgress(getGroupProgressService.execute(group.getId()));
                          return dto;
                      })
                      .collect(Collectors.toCollection(ArrayList::new));
    }
}
