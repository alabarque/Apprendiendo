package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;

public class DocumentMapper {

    public static DocumentDTO entityToDto(Document document){

        return DocumentDTO.builder().id(document.getId()).name(document.getName()).data(document.getData()).dataType(document.getDataType()).ownerId(document.getOwnerId()).build();

    }
}
