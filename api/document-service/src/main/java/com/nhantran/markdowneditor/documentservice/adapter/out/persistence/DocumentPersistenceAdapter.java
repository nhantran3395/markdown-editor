package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.out.CreateUpdateDeleteDocumentPort;
import com.nhantran.markdowneditor.documentservice.application.port.out.LoadDocumentPort;
import com.nhantran.markdowneditor.documentservice.common.PersistenceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
public class DocumentPersistenceAdapter implements LoadDocumentPort, CreateUpdateDeleteDocumentPort {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

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
        logger.debug("Found {} documents", documentJpaEntities.size());
        return documentJpaEntities.stream().map(documentMapper::mapToDomainEntity).toList();
    }

    @Override
    public List<Document> loadDocuments(String title) {
        List<DocumentJpaEntity> documentJpaEntities = documentRepository.findByTitleContainingIgnoreCase(title);
        logger.debug("Found {} documents", documentJpaEntities.size());
        return documentJpaEntities.stream().map(documentMapper::mapToDomainEntity).toList();
    }

    @Override
    public Optional<Document> loadDocument(Long documentId) {
        return documentRepository.findById(documentId).stream().map(documentMapper::mapToDomainEntity).findFirst();
    }

    @Override
    public Long createDocument(Document document) {
        DocumentContentJpaEntity contentEntity = new DocumentContentJpaEntity(
                null,
                document.getContent().getBytes(),
                null,
                null
        );
        DocumentJpaEntity documentEntity = new DocumentJpaEntity(
                null,
                document.getTitle(),
                contentEntity,
                null,
                null
        );
        return documentRepository.save(documentEntity).getId();
    }
}
