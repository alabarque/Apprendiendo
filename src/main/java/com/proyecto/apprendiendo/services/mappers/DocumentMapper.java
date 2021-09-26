package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.Project;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectDTO;

public class DocumentMapper {

    public static DocumentDTO entityToDto(Document document){

        return DocumentDTO.builder()
                          .id(document.getId())
                          .position(document.getPosition())
                          .name(document.getName())
                          .data(document.getData())
                          .dataType(document.getDataType()).build();
    }

    public static NewDocumentDTO dtoToNewDto(DocumentDTO documentDTO, Long sourceId, String documentSourceType){

        return NewDocumentDTO.builder()
                             .id(documentDTO.getId())
                             .position(documentDTO.getPosition())
                             .name(documentDTO.getName())
                             .data(documentDTO.getData())
                             .dataType(documentDTO.getDataType())
                             .sourceId(sourceId)
                             .documentSourceType(documentSourceType)
                             .build();
    }

    public static DocumentTemplateDTO entityToTemplateDto(Document document){

        return DocumentTemplateDTO.builder()
                                  .name(document.getName())
                                  .position(document.getPosition())
                                  .data(document.getData())
                                  .dataType(document.getDataType())
                                  .build();
    }

    public static NewDocumentDTO templateDtoToNewDto(DocumentTemplateDTO documentTemplateDTO, Long sourceId, String documentSourceType){

        return NewDocumentDTO.builder()
                             .name(documentTemplateDTO.getName())
                             .position(documentTemplateDTO.getPosition())
                             .data(documentTemplateDTO.getData())
                             .dataType(documentTemplateDTO.getDataType())
                             .sourceId(sourceId)
                             .documentSourceType(documentSourceType)
                             .build();
    }


}
