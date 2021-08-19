package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
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

    @PostMapping(path = "Document")
    public void newDocument(@RequestBody DocumentDTO DocumentDTO){
        createDocumentService.execute(DocumentDTO);
    }

    @GetMapping (path = "Document/{DocumentId}")
    public DocumentDTO getDocument(@PathVariable Long DocumentId){
        return getDocumentService.execute(DocumentId);
    }

    @DeleteMapping(path = "Document/{DocumentId}")
    public void deleteDocument(@PathVariable Long DocumentId){
        deleteDocumentService.execute(DocumentId);
    }

    @PutMapping(path = "Document")
    public void updateDocument(@RequestBody DocumentDTO DocumentDTO){
        updateDocumentService.execute(DocumentDTO);
    }
}
