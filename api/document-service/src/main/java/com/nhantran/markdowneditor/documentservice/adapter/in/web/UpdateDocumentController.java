package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.UpdateDocumentUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Documents")
public class UpdateDocumentController {
    private final UpdateDocumentUseCase updateDocumentUseCase;

    public UpdateDocumentController(UpdateDocumentUseCase updateDocumentUseCase) {
        this.updateDocumentUseCase = updateDocumentUseCase;
    }
}
