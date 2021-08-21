package com.proyecto.apprendiendo.services.mappers;

import com.proyecto.apprendiendo.entities.Avatar;
import com.proyecto.apprendiendo.entities.DocumentSource;
import com.proyecto.apprendiendo.entities.dtos.AvatarDTO;
import com.proyecto.apprendiendo.entities.dtos.SourceDTO;

public class SourceMapper {
    public static SourceDTO entityToDto(DocumentSource documentSource){
        return SourceDTO.builder().id(documentSource.getSourceId()).documentSourceType(documentSource.getDocumentSourceType()).build();
    }
}
