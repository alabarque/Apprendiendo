package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.NewProjectDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO.ProjectDTO;

public class ProjectMapper {

    public static ProjectDTO entityToDto(Project project){

        return ProjectDTO.builder().id(project.getId())
                                   .name(project.getName())
                                   .methodologyId(project.getMethodologyId())
                                   .challengeId(project.getChallengeId())
                                   .classroomId(project.getClassroomId())
                                   .build();

    }
}