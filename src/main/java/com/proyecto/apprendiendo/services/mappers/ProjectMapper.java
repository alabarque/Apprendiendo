package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;

public class ProjectMapper {

    public static ProjectDTO entityToDto(Project project) {

        return ProjectDTO.builder()
                         .id(project.getId())
                         .name(project.getName())
                         .description(project.getDescription())
                         .position(project.getPosition())
                         .methodologyId(project.getMethodologyId())
                         .classroomId(project.getClassroomId())
                         .startDate(project.getStartDate())
                         .dueDate(project.getDueDate())
                         .active(project.getActive())
                         .build();
    }

    public static ProjectTemplateDTO entityToTemplateDto(Project project) {

        return ProjectTemplateDTO.builder()
                                 .name(project.getName())
                                 .description(project.getDescription())
                                 .classroomId(project.getClassroomId())
                                 .position(project.getPosition())
                                 .startDate(project.getStartDate())
                                 .dueDate(project.getDueDate())
                                 .active(project.getActive())
                                 .build();
    }

    public static ProjectDTO templateToDto(ProjectTemplateDTO projectTemplateDTO) {

        return ProjectDTO.builder()
                         .name(projectTemplateDTO.getName())
                         .description(projectTemplateDTO.getDescription())
                         .classroomId(projectTemplateDTO.getClassroomId())
                         .position(projectTemplateDTO.getPosition())
                         .startDate(projectTemplateDTO.getStartDate())
                         .dueDate(projectTemplateDTO.getDueDate())
                         .active(projectTemplateDTO.getActive())
                         .build();
    }

}
