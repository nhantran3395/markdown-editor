package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.out.CreateUpdateDeleteDocumentPort;
import com.nhantran.markdowneditor.documentservice.application.port.out.LoadDocumentPort;
import com.nhantran.markdowneditor.documentservice.common.PersistenceAdapter;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
public class DocumentPersistenceAdapter implements LoadDocumentPort, CreateUpdateDeleteDocumentPort {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentPersistenceAdapter(
            DocumentRepository documentRepository,
            DocumentMapper documentMapper
    ) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }

    @Override
    public List<Document> loadDocuments() {
        List<DocumentJpaEntity> documentJpaEntities = documentRepository.findAll();
        return documentJpaEntities.stream().map(documentMapper::mapToDomainEntity).toList();
    }

    @Override
    public Optional<Document> loadDocument(Long documentId) {
        return documentRepository.findById(documentId).stream().map(documentMapper::mapToDomainEntity).findFirst();
    }
}
