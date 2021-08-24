package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.services.abm_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.DeleteDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.GetDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.UpdateDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMDocumentController {

    private CreateDocumentService createDocumentService;
    private GetDocumentService getDocumentService;
    private DeleteDocumentService deleteDocumentService;
    private UpdateDocumentService updateDocumentService;

    @PostMapping(path = "document")
    public void newDocument(@RequestBody NewDocumentDTO newDocumentDTO){createDocumentService.execute(newDocumentDTO);}

    @GetMapping (path = "document/{documentId}")
    public DocumentDTO getDocument(@PathVariable Long documentId){
        return getDocumentService.execute(documentId);
    }

    @DeleteMapping(path = "document/{documentId}/source/{sourceId}")
    public void deleteDocument( @PathVariable("documentId") Long documentId, @PathVariable("sourceId") Long sourceId){ deleteDocumentService.execute(documentId, sourceId);}

    @PutMapping(path = "document")
    public void updateDocument(@RequestBody DocumentDTO documentDTO){updateDocumentService.execute(documentDTO);
    }
}
