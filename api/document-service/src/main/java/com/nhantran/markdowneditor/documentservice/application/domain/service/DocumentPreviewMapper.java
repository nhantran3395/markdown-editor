package com.nhantran.markdowneditor.documentservice.application.domain.service;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import org.springframework.stereotype.Component;

@Component
public class DocumentPreviewMapper {
    DocumentPreview mapToDocumentPreview(Document document) {
        return new DocumentPreview(
                document.getId(),
                document.getTitle(),
                document.getCreatedDate(),
                document.getModifiedDate()
        );
    }
}
