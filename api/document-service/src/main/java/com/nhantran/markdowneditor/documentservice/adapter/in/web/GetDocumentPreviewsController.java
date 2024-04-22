package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class GetDocumentPreviewsController implements GetDocumentPreviewsUseCase {
    @GetMapping("/documents")
    @Override
    public List<DocumentPreview> getDocumentPreviews() {
        return Collections.emptyList();
    }
}
