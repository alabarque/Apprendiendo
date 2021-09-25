package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;

public class DocumentMapper {

    public static DocumentDTO entityToDto(Document document){

        return DocumentDTO.builder()
                          .id(document.getId())
                          .name(document.getName())
                          .data(document.getData())
                          .dataType(document.getDataType())
                          .ownerId(document.getOwnerId()).build();
    }

    public static NewDocumentDTO DtoToNewDto(DocumentDTO documentDTO, Long sourceId, String documentSourceType){

        return NewDocumentDTO.builder()
                             .id(documentDTO.getId())
                             .name(documentDTO.getName())
                             .data(documentDTO.getData())
                             .dataType(documentDTO.getDataType())
                             .ownerId(documentDTO.getOwnerId())
                             .sourceId(sourceId)
                             .documentSourceType(documentSourceType)
                             .build();
    }
}
