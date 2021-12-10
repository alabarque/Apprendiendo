package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE)
public class AddStudentTargetDocumentService {

    private StudentClassroomRepository studentClassroomRepository;
    private StudentProjectRepository studentProjectRepository;
    private StudentActivityRepository studentActivityRepository;
    private CreateDocumentService createDocumentService;

    public Long execute(Long studentId, Long targetId, String targetType, DocumentDTO documentDTO) {

        Long newDocumentId = 0L;

        if (targetType.equals(TargetType.STUDENT_PROJECT.toString())) {
            StudentProject target = studentProjectRepository.findByStudentIdAndProjectId(studentId,targetId);
            if ( target == null){
                target = studentProjectRepository.save(StudentProject.builder()
                                                                       .projectId(targetId)
                                                                       .studentId(studentId)
                                                                       .build());
            }
            documentDTO.setDocumentSourceType("STUDENT_PROJECT");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);

        }

        if (targetType.equals(TargetType.STUDENT_ACTIVITY.toString())) {
            StudentActivity target = studentActivityRepository.findByStudentIdAndActivityId(studentId,targetId);
            if ( target == null){
                target = studentActivityRepository.save(StudentActivity.builder()
                                                                       .activityId(targetId)
                                                                       .studentId(studentId)
                                                                       .build());
            }
            documentDTO.setDocumentSourceType("STUDENT_ACTIVITY");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);
        }

        if (targetType.equals(TargetType.STUDENT_CLASSROOM.toString())) {
            StudentClassroom target = studentClassroomRepository.findByStudentIdAndClassroomId(studentId,targetId);
            if ( target == null){
                target = studentClassroomRepository.save(StudentClassroom.builder()
                                                                       .classroomId(targetId)
                                                                       .studentId(studentId)
                                                                       .build());
            }
            documentDTO.setDocumentSourceType("STUDENT_CLASSROOM");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);
        }

        return newDocumentId;
    }
}
