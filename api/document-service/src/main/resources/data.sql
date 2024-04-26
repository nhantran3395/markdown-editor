INSERT INTO "DocumentContent" (content, created_date, modified_date)
VALUES ('this is a default Markdown document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "Document" (document_content_id, title, created_date, modified_date)
VALUES (1, 'default document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "DocumentContent" (content, created_date, modified_date)
VALUES ('hello, welcome to markdown editor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO "Document" (document_content_id, title, created_date, modified_date)
VALUES (2, 'welcome.md', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
