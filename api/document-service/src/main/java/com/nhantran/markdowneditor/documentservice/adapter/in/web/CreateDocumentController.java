package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentCommand;
import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CreateDocumentController {
    private final CreateDocumentUseCase createDocumentUseCase;

    public CreateDocumentController(CreateDocumentUseCase createDocumentUseCase) {
        this.createDocumentUseCase = createDocumentUseCase;
    }

    @PostMapping("/documents")
    public ResponseEntity<Void> createDocument(@RequestBody @Validated CreateDocumentCommand createDocumentCommand) {
        Long id = createDocumentUseCase.createDocument(createDocumentCommand);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{documentId}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
