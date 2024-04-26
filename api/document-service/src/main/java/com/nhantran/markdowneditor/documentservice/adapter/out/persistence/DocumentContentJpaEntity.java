package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Arrays;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`DocumentContent`")
public class DocumentContentJpaEntity {
    @Id
    @Column(name = "document_content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] content;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;

    public DocumentContentJpaEntity(Long id, byte[] content, Instant createdDate, Instant modifiedDate) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public DocumentContentJpaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "DocumentContentJpaEntity{" +
                "id=" + id +
                ", content=" + Arrays.toString(content) +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}