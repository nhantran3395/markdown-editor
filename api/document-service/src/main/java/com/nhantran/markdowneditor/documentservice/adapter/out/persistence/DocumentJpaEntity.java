package com.nhantran.markdowneditor.documentservice.adapter.out.persistence;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`Document`")
public class DocumentJpaEntity {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "document_content_id", name = "document_content_id")
    private DocumentContentJpaEntity content;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;

    public DocumentJpaEntity(Long id, String title, DocumentContentJpaEntity content, Instant createdDate, Instant modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public DocumentJpaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DocumentContentJpaEntity getContent() {
        return content;
    }

    public void setContent(DocumentContentJpaEntity content) {
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
        return "DocumentJpaEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
