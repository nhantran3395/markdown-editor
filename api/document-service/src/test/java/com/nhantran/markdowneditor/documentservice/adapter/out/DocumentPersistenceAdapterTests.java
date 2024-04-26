package com.nhantran.markdowneditor.documentservice.adapter.out;

import com.nhantran.markdowneditor.documentservice.TestContainersConfiguration;
import com.nhantran.markdowneditor.documentservice.adapter.out.persistence.DocumentPersistenceAdapter;
import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {TestContainersConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
class DocumentPersistenceAdapterTests {
    @Autowired
    private DocumentPersistenceAdapter documentPersistenceAdapter;

    @Test
    void whenFindAll_thenReturnsAllDocuments() {
        List<Document> documents = documentPersistenceAdapter.loadDocuments();
        assertThat(documents).hasSize(2);
        assertThat(documents.get(0).getId()).isEqualTo(1L);
        assertThat(documents.get(0).getTitle()).isEqualTo("default document");
        assertThat(documents.get(0).getContent()).isEqualTo("this is a default Markdown document");
        assertThat(documents.get(1).getId()).isEqualTo(2L);
        assertThat(documents.get(1).getTitle()).isEqualTo("welcome.md");
        assertThat(documents.get(1).getContent()).isEqualTo("hello, welcome to markdown editor");
    }

    @Test
    void givenDocumentsWithMatchingTitleExists_whenFindByTitle_thenReturnsListOfDocuments() {
        List<Document> documents = documentPersistenceAdapter.loadDocuments("welcome");
        assertThat(documents).hasSize(1);
        assertThat(documents.get(0).getId()).isEqualTo(2L);
        assertThat(documents.get(0).getTitle()).isEqualTo("welcome.md");
        assertThat(documents.get(0).getContent()).isEqualTo("hello, welcome to markdown editor");
    }

    @Test
    void givenNoDocumentWithMatchingTitle_whenFindByTitle_thenReturnEmptyList() {
        List<Document> documents = documentPersistenceAdapter.loadDocuments("markdown");
        assertThat(documents).isEmpty();
    }
}
