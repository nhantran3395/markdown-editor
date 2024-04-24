package com.nhantran.markdowneditor.documentservice.application.port.in;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;

import java.util.Optional;

public interface GetDocumentDetailUseCase {
    Optional<Document> getDocumentDetail(Long documentId);
}
