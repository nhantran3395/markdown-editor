package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@Table(name = "DocumentContent")
public class DocumentContentJpaEntity {
    @Id
    @GeneratedValue
    @Column(name = "document_content_id")
    private Long id;

    private byte[] content;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp modifiedDate;
}