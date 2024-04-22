package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.UpdateDocumentUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateDocumentController {
    private final UpdateDocumentUseCase updateDocumentUseCase;

    public UpdateDocumentController(UpdateDocumentUseCase updateDocumentUseCase) {
        this.updateDocumentUseCase = updateDocumentUseCase;
    }
}
