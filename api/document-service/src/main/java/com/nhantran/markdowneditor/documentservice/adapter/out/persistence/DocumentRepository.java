package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentJpaEntity, Long> {
}