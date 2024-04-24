package com.nhantran.markdowneditor.documentservice.application.domain.service;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import com.nhantran.markdowneditor.documentservice.application.port.out.LoadDocumentPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetDocumentDetailService implements GetDocumentDetailUseCase {
    private final LoadDocumentPort loadDocumentPort;

    public GetDocumentDetailService(LoadDocumentPort loadDocumentPort) {
        this.loadDocumentPort = loadDocumentPort;
    }

    @Override
    public Optional<Document> getDocumentDetail(Long documentId) {
        return loadDocumentPort.loadDocument(documentId);
    }
}
