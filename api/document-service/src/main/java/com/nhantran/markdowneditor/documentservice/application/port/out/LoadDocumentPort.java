package com.nhantran.markdowneditor.documentservice.application.port.out;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;

import java.util.List;
import java.util.Optional;

public interface LoadDocumentPort {
    List<Document> loadDocuments();

    List<Document> loadDocuments(String title);

    Optional<Document> loadDocument(Long documentId);
}
