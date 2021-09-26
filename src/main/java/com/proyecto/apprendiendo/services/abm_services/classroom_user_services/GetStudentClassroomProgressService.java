package com.proyecto.apprendiendo.services.abm_services.classroom_user_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.StudentClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentProjectDTO;
import com.proyecto.apprendiendo.repositories.ClassroomRepository;
import com.proyecto.apprendiendo.repositories.ProjectRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.abm_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.mappers.StudentClassroomMapper;
import com.proyecto.apprendiendo.services.mappers.StudentProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentClassroomProgressService {

    private StudentClassroomRepository studentClassroomRepository;
    private StudentProjectRepository studentProjectRepository;
    private GetStudentProjectProgressService getStudentProjectProgressService;
    private ClassroomRepository classroomRepository;
    private ProjectRepository projectRepository;

    public StudentClassroomDTO execute(Long studentId, Long classroomId){
        StudentClassroomDTO studentClassroomDTO = StudentClassroomMapper.entityToDto(studentClassroomRepository.findByStudentIdAndClassroomId(studentId, classroomId));

        if(studentClassroomDTO.getPercentageCompleted() == 0.00) {
            Double percentageCompleted = studentProjectRepository.findByUserId(studentId)
                                                                 .stream()
                                                                 .filter(sp -> projectRepository.getById(sp.getProjectId()).getClassroomId().equals(classroomId))
                                                                 .mapToDouble(sp -> getStudentProjectProgressService.execute(sp.getUserId(), sp.getProjectId()).getPercentageCompleted())
                                                                 .average()
                                                                 .getAsDouble();

            studentClassroomDTO.setPercentageCompleted(percentageCompleted);
        }


        return studentClassroomDTO;
    }
}
