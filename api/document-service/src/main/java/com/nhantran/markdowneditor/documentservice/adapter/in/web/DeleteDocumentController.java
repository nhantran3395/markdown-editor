package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DeleteDocumentUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Documents")
public class DeleteDocumentController {
    private final DeleteDocumentUseCase deleteDocumentUseCase;

    public DeleteDocumentController(DeleteDocumentUseCase deleteDocumentUseCase) {
        this.deleteDocumentUseCase = deleteDocumentUseCase;
    }
}
