package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {
    public Document mapToDomainEntity(DocumentJpaEntity documentJpaEntity) {
        return new Document(
                documentJpaEntity.getId(),
                documentJpaEntity.getTitle(),
                documentJpaEntity.getCreatedDate(),
                documentJpaEntity.getModifiedDate(),
                new String(documentJpaEntity.getContent().getContent())
        );
    }
}
