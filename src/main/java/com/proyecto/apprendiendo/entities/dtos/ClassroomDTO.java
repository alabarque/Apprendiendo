package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class ClassroomDTO {
    private Long id;
    private Long teacherId;
    private UserDTO teacher;
    private String subject;
    private Integer year;
    private String division;

    private ArrayList<StudentDTO> students;
    private ArrayList<ProjectDTO> projects;
    private ArrayList<RewardDTO> rewards;
    private ArrayList<DocumentDTO> documents;
    private ArrayList<StudentClassroomDTO> studentsProgress;
}
