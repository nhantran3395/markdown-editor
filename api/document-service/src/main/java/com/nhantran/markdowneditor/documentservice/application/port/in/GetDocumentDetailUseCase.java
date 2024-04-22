package com.nhantran.markdowneditor.documentservice.application.port.in;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;

public interface GetDocumentDetailUseCase {
    Document getDocumentDetail(String documentId);
}
