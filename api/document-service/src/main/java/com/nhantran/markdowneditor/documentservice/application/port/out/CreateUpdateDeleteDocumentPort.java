package com.nhantran.markdowneditor.documentservice.application.port.out;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;

public interface CreateUpdateDeleteDocumentPort {
    Long createDocument(Document document);
}
