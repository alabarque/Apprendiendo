package com.proyecto.apprendiendo.services.general_services.group_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.services.general_services.group_student_services.GetGroupStudentsService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class GetGroupProgressService {

    private GroupRepository groupRepository;
    private GetStudentProjectProgressService getStudentProjectProgressService;
    private GetGroupStudentsService getGroupStudentsService;

    public Double execute(Long groupId) {

        Group group = groupRepository.getById(groupId);
        ArrayList<GroupStudentDTO> students = getGroupStudentsService.execute(groupId);
        if (students.size() == 0) return 0.00;

        return students.stream()
                       .mapToDouble(student -> getStudentProjectProgressService.execute(student.getStudentId(),group.getProjectId()).getPercentageCompleted())
                       .average()
                       .getAsDouble();
    }
}
