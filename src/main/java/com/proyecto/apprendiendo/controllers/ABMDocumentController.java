package com.proyecto.apprendiendo.controllers;

import com.proyecto.apprendiendo.entities.dtos.DocumentDTO;
import com.proyecto.apprendiendo.entities.dtos.NewDocumentDTO;
import com.proyecto.apprendiendo.services.abm_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.DeleteDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.GetDocumentService;
import com.proyecto.apprendiendo.services.abm_services.document_services.UpdateDocumentService;
import com.proyecto.apprendiendo.utils.ResponseDecorator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ABMDocumentController {

    private CreateDocumentService createDocumentService;
    private GetDocumentService getDocumentService;
    private DeleteDocumentService deleteDocumentService;
    private UpdateDocumentService updateDocumentService;
    private ResponseDecorator responseDecorator;

    @PostMapping(path = "document")
    public ResponseEntity<Long> newDocument(@RequestBody NewDocumentDTO newDocumentDTO){
        return responseDecorator.decorate(()->createDocumentService.execute(newDocumentDTO));
    }

    @GetMapping (path = "document/{documentId}")
    public ResponseEntity< DocumentDTO> getDocument(@PathVariable Long documentId){
        return responseDecorator.decorate(()->getDocumentService.execute(documentId));
    }

    @DeleteMapping(path = "document/{documentId}/source/{sourceId}")
    public ResponseEntity<Long> deleteDocument( @PathVariable("documentId") Long documentId, @PathVariable("sourceId") Long sourceId){
        return responseDecorator.decorate(()->deleteDocumentService.execute(documentId, sourceId));
    }

    @PutMapping(path = "document")
    public ResponseEntity<Long> updateDocument(@RequestBody DocumentDTO documentDTO){
        return responseDecorator.decorate(()->updateDocumentService.execute(documentDTO));
    }
}
