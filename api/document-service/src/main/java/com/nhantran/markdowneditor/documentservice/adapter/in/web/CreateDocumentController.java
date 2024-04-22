package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateDocumentController {
    private final CreateDocumentUseCase createDocumentUseCase;

    public CreateDocumentController(CreateDocumentUseCase createDocumentUseCase) {
        this.createDocumentUseCase = createDocumentUseCase;
    }
}
