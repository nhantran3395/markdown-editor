package com.nhantran.markdowneditor.documentservice.application.domain.service;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import com.nhantran.markdowneditor.documentservice.application.port.out.LoadDocumentPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDocumentPreviewsService implements GetDocumentPreviewsUseCase {
    private final LoadDocumentPort loadDocumentPort;
    private final DocumentPreviewMapper documentPreviewMapper;

    public GetDocumentPreviewsService(LoadDocumentPort loadDocumentPort, DocumentPreviewMapper documentPreviewMapper) {
        this.loadDocumentPort = loadDocumentPort;
        this.documentPreviewMapper = documentPreviewMapper;
    }

    @Override
    public List<DocumentPreview> getDocumentPreviews() {
        List<Document> documents = loadDocumentPort.loadDocuments();
        return documents.stream().map(documentPreviewMapper::mapToDocumentPreview).toList();
    }
}
