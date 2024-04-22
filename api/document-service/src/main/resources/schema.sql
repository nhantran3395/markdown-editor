CREATE TABLE "DocumentContent"
(
    document_content_id BIGINT NOT NULL,
    content             BYTEA,
    created_date        TIMESTAMP WITHOUT TIME ZONE,
    modified_date       TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_documentcontent PRIMARY KEY (document_content_id)
);

CREATE TABLE "Document"
(
    document_id         BIGINT       NOT NULL,
    title               VARCHAR(255) NOT NULL,
    document_content_id BIGINT,
    created_date        TIMESTAMP WITHOUT TIME ZONE,
    modified_date       TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_document PRIMARY KEY (document_id)
);

ALTER TABLE "Document"
    ADD CONSTRAINT uc_document_document_content UNIQUE (document_content_id);

ALTER TABLE "Document"
    ADD CONSTRAINT uc_document_title UNIQUE (title);

ALTER TABLE "Document"
    ADD CONSTRAINT FK_DOCUMENT_ON_DOCUMENT_CONTENT FOREIGN KEY (document_content_id) REFERENCES "DocumentContent" (document_content_id);