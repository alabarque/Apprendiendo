package com.proyecto.apprendiendo.services.general_services.group_student_services;

import com.proyecto.apprendiendo.entities.GroupStudent;
import com.proyecto.apprendiendo.entities.dtos.GroupDTO;
import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import com.proyecto.apprendiendo.services.general_services.group_services.GetGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class GetProjectStudentGroupService {

    private GroupStudentRepository groupStudentRepository;
    private GetGroupService getGroupService;

    public GroupDTO execute(Long projectId, Long studentId) {
        Optional<GroupStudent> group = groupStudentRepository.findByStudentId(studentId)
                                                             .stream()
                                                             .filter(gs -> getGroupService.execute(gs.getGroupId()).getProjectId().equals(projectId))
                                                             .findAny();
        if(group.isPresent()) return getGroupService.execute(group.get().getGroupId());
        else return null;
    }
}
