package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectTemplateDTO;

public class ProjectMapper {

    public static ProjectDTO entityToDto(Project project){

        return ProjectDTO.builder()
                         .id(project.getId())
                         .name(project.getName())
                         .position(project.getPosition())
                         .methodologyId(project.getMethodologyId())
                         .classroomId(project.getClassroomId())
                         .startDate(project.getStartDate())
                         .dueDate(project.getDueDate())
                         .build();
    }

    public static ProjectTemplateDTO entityToTemplateDto(Project project){

        return ProjectTemplateDTO.builder()
                                 .name(project.getName())
                                 .position(project.getPosition())
                                 .startDate(project.getStartDate())
                                 .dueDate(project.getDueDate())
                                 .build();
    }

    public static ProjectNewDTO templateToNew(ProjectTemplateDTO projectTemplateDTO){

        return ProjectNewDTO.builder()
                            .name(projectTemplateDTO.getName())
                            .position(projectTemplateDTO.getPosition())
                            .startDate(projectTemplateDTO.getStartDate())
                            .dueDate(projectTemplateDTO.getDueDate())
                            .build();
    }

}
