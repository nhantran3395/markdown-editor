INSERT INTO "DocumentContent" (document_content_id, content, created_date, modified_date)
VALUES (1, 'this is a default Markdown document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "Document" (document_id, document_content_id, title, created_date, modified_date)
VALUES (1, 1, 'default document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "DocumentContent" (document_content_id, content, created_date, modified_date)
VALUES (2, 'hello, welcome to markdown editor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "Document" (document_id, document_content_id, title, created_date, modified_date)
VALUES (2, 2, 'welcome.md', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
