package com.proyecto.apprendiendo.services.general_services.group_student_services;

import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;
import com.proyecto.apprendiendo.repositories.GroupStudentRepository;
import com.proyecto.apprendiendo.services.mappers.GroupStudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetGroupStudentsService {

    private GroupStudentRepository groupStudentRepository;

    public ArrayList<GroupStudentDTO> execute(Long groupId) {
        return groupStudentRepository.findByGroupId(groupId)
                                     .stream()
                                     .map(gs -> GroupStudentMapper.entityToDto(gs))
                                     .collect(Collectors.toCollection(ArrayList::new));
    }
}
