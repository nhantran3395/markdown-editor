package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentJpaEntity, Long> {
    List<DocumentJpaEntity> findByTitleContainingIgnoreCase(String title);
}