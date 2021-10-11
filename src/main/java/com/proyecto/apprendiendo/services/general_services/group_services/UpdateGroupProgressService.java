package com.proyecto.apprendiendo.services.general_services.group_services;

import com.proyecto.apprendiendo.entities.Group;
import com.proyecto.apprendiendo.entities.dtos.GroupProgressDTO;
import com.proyecto.apprendiendo.entities.dtos.GroupStudentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.GroupRepository;
import com.proyecto.apprendiendo.services.general_services.group_student_services.GetGroupStudentsService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.UpdateStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class UpdateGroupProgressService {

    private GroupRepository groupRepository;
    private UpdateStudentProjectProgressService updateStudentProjectProgressService;
    private GetGroupStudentsService getGroupStudentsService;

    public Long execute(Long groupId, GroupProgressDTO groupProgressDTO) {
        Group group = groupRepository.getById(groupId);
        ArrayList<GroupStudentDTO> students = getGroupStudentsService.execute(groupId);

        students.forEach(student -> {
            StudentProjectDTO studentProjectDTO = StudentProjectDTO.builder()
                                                                   .percentageCompleted(groupProgressDTO.getPercentageCompleted())
                                                                   .grade(groupProgressDTO.getGrade())
                                                                   .dateCompleted(groupProgressDTO.getDateCompleted())
                                                                   .projectId(group.getProjectId())
                                                                   .userId(student.getStudentId())
                                                                   .build();

            updateStudentProjectProgressService.execute(student.getStudentId(),group.getProjectId(),studentProjectDTO);
        });
        return  groupId;
    }
}
