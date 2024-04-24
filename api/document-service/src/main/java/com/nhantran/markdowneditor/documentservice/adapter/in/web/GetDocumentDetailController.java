package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetDocumentDetailController {

    private final GetDocumentDetailUseCase getDocumentDetailUseCase;

    public GetDocumentDetailController(GetDocumentDetailUseCase getDocumentDetailUseCase) {
        this.getDocumentDetailUseCase = getDocumentDetailUseCase;
    }

    @GetMapping("documents/{documentId}")
    public ResponseEntity<Document> getDocumentDetail(@PathVariable("documentId") Long documentId) {
        Optional<Document> document = getDocumentDetailUseCase.getDocumentDetail(documentId);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
