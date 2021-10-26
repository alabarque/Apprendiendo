package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Document;
import com.proyecto.apprendiendo.entities.DocumentSummary;
import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.DocumentTemplateDTO;

public class DocumentMapper {

    public static DocumentDTO entityToDto(Document document) {
        return DocumentDTO.builder()
                          .id(document.getId())
                          .position(document.getPosition())
                          .name(document.getName())
                          .data(document.getData())
                          .dataType(document.getDataType())
                          .sourceId(document.getSourceId())
                          .documentSourceType(document.getDocumentSourceType())
                          .build();
    }

    public static DocumentDTO entitySummaryToDto(DocumentSummary document) {
        return DocumentDTO.builder()
                          .id(document.getId())
                          .position(document.getPosition())
                          .name(document.getName())
                          .dataType(document.getDataType())
                          .data(null)
                          .sourceId(document.getSourceId())
                          .documentSourceType(document.getDocumentSourceType())
                          .build();
    }
    public static DocumentTemplateDTO entityToTemplateDto(Document document) {
        return DocumentTemplateDTO.builder()
                                  .name(document.getName())
                                  .position(document.getPosition())
                                  .data(document.getData())
                                  .dataType(document.getDataType())
                                  .build();
    }

    public static DocumentDTO templateDtoToDto(DocumentTemplateDTO documentTemplateDTO, Long sourceId, String documentSourceType) {
        return DocumentDTO.builder()
                          .name(documentTemplateDTO.getName())
                          .position(documentTemplateDTO.getPosition())
                          .data(documentTemplateDTO.getData())
                          .dataType(documentTemplateDTO.getDataType())
                          .sourceId(sourceId)
                          .documentSourceType(documentSourceType)
                          .build();
    }


}
