package com.proyecto.apprendiendo.services.general_services.document_services;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.StudentActivity;
import com.proyecto.apprendiendo.entities.StudentClassroom;
import com.proyecto.apprendiendo.entities.StudentProject;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.enums.DocumentSourceType;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.mappers.DocumentMapper;
import lombok.AllArgsConstructor;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GetStudentSourcesDocumentsService {

    private GetSourcesDocumentsService getSourcesDocumentsService;
    private StudentActivityRepository studentActivityRepository;
    private StudentProjectRepository studentProjectRepository;
    private StudentClassroomRepository studentClassroomRepository;

    public ArrayList<DocumentDTO> execute(Long studentId, Long sourceId, String sourceType) {
        return execute(studentId, sourceId, sourceType, "FULL");
    }

    public ArrayList<DocumentDTO> execute(Long studentId, Long sourceId, String sourceType, String mode) {
        return execute(studentId, sourceId, sourceType, mode, null);
    }

    public ArrayList<DocumentDTO> execute(Long studentId, Long sourceId, String sourceType, String mode, String documentType) {
        Long studentSourceId = 0L;
        if (sourceType.equals(DocumentSourceType.ACTIVITY.getValue())) {
            StudentActivity studentActivity = studentActivityRepository.findByStudentIdAndActivityId(studentId, sourceId);
            if (studentActivity != null) studentSourceId = studentActivity.getId();
        }
        if (sourceType.equals(DocumentSourceType.PROJECT.getValue())) {
            StudentProject studentActivity = studentProjectRepository.findByStudentIdAndProjectId(studentId, sourceId);
            if (studentActivity != null) studentSourceId = studentActivity.getId();
        }
        if (sourceType.equals(DocumentSourceType.CLASSROOM.getValue())) {
            StudentClassroom studentActivity = studentClassroomRepository.findByStudentIdAndClassroomId(studentId, sourceId);
            if (studentActivity != null) studentSourceId = studentActivity.getId();
        }

        return getSourcesDocumentsService.execute(studentSourceId, mode, documentType);
    }
}
