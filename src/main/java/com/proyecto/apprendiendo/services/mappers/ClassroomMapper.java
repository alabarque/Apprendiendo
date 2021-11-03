package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;

public class ClassroomMapper {

    public static ClassroomDTO entityToDto(Classroom classroom) {
        return ClassroomDTO.builder()
                           .id(classroom.getId())
                           .teacherId(classroom.getTeacherId())
                           .year(classroom.getYear())
                           .subject(classroom.getSubject())
                           .division(classroom.getDivision())
                           .build();
    }
}
