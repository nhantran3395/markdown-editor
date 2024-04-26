package com.nhantran.markdowneditor.documentservice.application.port.in;

public interface CreateDocumentUseCase {
    Long createDocument(CreateDocumentCommand createDocumentCommand);
}
