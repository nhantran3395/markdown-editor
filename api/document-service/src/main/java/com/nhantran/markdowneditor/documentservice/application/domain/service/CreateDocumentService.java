package com.nhantran.markdowneditor.documentservice.application.domain.service;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentCommand;
import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentUseCase;
import com.nhantran.markdowneditor.documentservice.application.port.out.CreateUpdateDeleteDocumentPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDocumentService implements CreateDocumentUseCase {
    private final CreateUpdateDeleteDocumentPort createUpdateDeleteDocumentPort;

    public CreateDocumentService(CreateUpdateDeleteDocumentPort createUpdateDeleteDocumentPort) {
        this.createUpdateDeleteDocumentPort = createUpdateDeleteDocumentPort;
    }

    @Override
    public Long createDocument(CreateDocumentCommand createDocumentCommand) {
        Document document = new Document(
                null,
                createDocumentCommand.title(),
                null,
                null,
                createDocumentCommand.content()
        );
        return createUpdateDeleteDocumentPort.createDocument(document);
    }
}
