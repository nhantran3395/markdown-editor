package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDocumentDetailController {

    private final GetDocumentDetailUseCase getDocumentDetailUseCase;

    public GetDocumentDetailController(GetDocumentDetailUseCase getDocumentDetailUseCase) {
        this.getDocumentDetailUseCase = getDocumentDetailUseCase;
    }

    @GetMapping("documents/{documentId}")
    public Document getDocumentDetail(@PathVariable("documentId") String documentId) {
        return getDocumentDetailUseCase.getDocumentDetail(documentId);
    }
}
