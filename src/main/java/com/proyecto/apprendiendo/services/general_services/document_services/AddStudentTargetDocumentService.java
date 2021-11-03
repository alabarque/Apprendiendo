package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.repositories.DocumentRepository;
import com.proyecto.apprendiendo.repositories.StudentActivityRepository;
import com.proyecto.apprendiendo.repositories.StudentClassroomRepository;
import com.proyecto.apprendiendo.repositories.StudentProjectRepository;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.AddClassroomStudentService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.UpdateStudentClassroomProgressService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetStudentLessonProgressService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.AddActivityStudentsService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.UpdateStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.AddProjectStudentsService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetProjectStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.UpdateStudentProjectProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AddStudentTargetDocumentService {

    private StudentClassroomRepository studentClassroomRepository;
    private StudentProjectRepository studentProjectRepository;
    private StudentActivityRepository studentActivityRepository;
    private AddActivityStudentsService addActivityStudentsService;
    private AddProjectStudentsService addProjectStudentsService;
    private AddClassroomStudentService addClassroomStudentService;
    private CreateDocumentService createDocumentService;

    public Long execute(Long studentId, Long targetId, String targetType, DocumentDTO documentDTO) {

        Long newDocumentId = 0L;

        if (targetType.equals(TargetType.PROJECT.toString())) {
            addProjectStudentsService.execute(targetId, studentId);
            StudentProject target = studentProjectRepository.findByStudentIdAndProjectId(studentId,targetId);
            documentDTO.setDocumentSourceType("STUDENT_PROJECT");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);

        }

        if (targetType.equals(TargetType.ACTIVITY.toString())) {
            addActivityStudentsService.execute(targetId, studentId);
            StudentActivity target = studentActivityRepository.findByStudentIdAndActivityId(studentId,targetId);
            documentDTO.setDocumentSourceType("STUDENT_ACTIVITY");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);
        }

        if (targetType.equals(TargetType.CLASSROOM.toString())) {
            addClassroomStudentService.execute(targetId, studentId);
            StudentClassroom target = studentClassroomRepository.findByStudentIdAndClassroomId(studentId,targetId);
            documentDTO.setDocumentSourceType("STUDENT_CLASSROOM");
            documentDTO.setSourceId(target.getId());
            newDocumentId = createDocumentService.execute(documentDTO);
        }

        return newDocumentId;
    }
}
