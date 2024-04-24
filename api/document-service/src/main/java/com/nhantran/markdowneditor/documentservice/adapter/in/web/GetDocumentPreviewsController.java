package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDocumentPreviewsController {
    private final GetDocumentPreviewsUseCase getDocumentPreviewsUseCase;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GetDocumentPreviewsController(GetDocumentPreviewsUseCase getDocumentPreviewsUseCase) {
        this.getDocumentPreviewsUseCase = getDocumentPreviewsUseCase;
    }

    @GetMapping("/documents/previews")
    public List<DocumentPreview> getDocumentPreviews(@RequestParam(name = "title", required = false) String documentTitle) {
        logger.debug("title {}", documentTitle);
        return getDocumentPreviewsUseCase.getDocumentPreviews(documentTitle);
    }
}
