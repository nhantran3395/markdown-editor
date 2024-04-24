package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDocumentPreviewsController {
    private final GetDocumentPreviewsUseCase getDocumentPreviewsUseCase;

    public GetDocumentPreviewsController(GetDocumentPreviewsUseCase getDocumentPreviewsUseCase) {
        this.getDocumentPreviewsUseCase = getDocumentPreviewsUseCase;
    }

    @GetMapping("/documents/previews")
    public List<DocumentPreview> getDocumentPreviews() {
        return getDocumentPreviewsUseCase.getDocumentPreviews();
    }
}
