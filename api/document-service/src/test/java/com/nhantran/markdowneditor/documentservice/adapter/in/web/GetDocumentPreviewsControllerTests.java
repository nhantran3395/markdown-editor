package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GetDocumentPreviewsController.class)
class GetDocumentPreviewsControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetDocumentPreviewsUseCase getDocumentPreviewsUseCase;

    @Test
    void returnsDocumentPreviews() throws Exception {
        Instant currentTime = Instant.now();
        DocumentPreview documentPreview = new DocumentPreview(1L, "default document", currentTime, currentTime);
        given(getDocumentPreviewsUseCase.getDocumentPreviews(null)).willReturn(List.of(documentPreview));

        mockMvc.perform(
                        get("/documents/previews")
                                .accept("application/json")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$..id").value(1))
                .andExpect(jsonPath("$..title").value("default document"))
                .andExpect(jsonPath("$..createdDate").value(currentTime.toString()))
                .andExpect(jsonPath("$..modifiedDate").value(currentTime.toString()));


        verify(getDocumentPreviewsUseCase).getDocumentPreviews(null);
    }

    @Test
    void givenDocumentExists_whenFindByTitle_thenReturnsDocumentPreviews() throws Exception {
        Instant currentTime = Instant.now();
        String searchTerm = "default";
        DocumentPreview documentPreview = new DocumentPreview(1L, "default document", currentTime, currentTime);

        given(getDocumentPreviewsUseCase.getDocumentPreviews(searchTerm)).willReturn(List.of(documentPreview));

        mockMvc.perform(
                        get("/documents/previews?title=" + searchTerm)
                                .accept("application/json")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$..id").value(1))
                .andExpect(jsonPath("$..title").value("default document"))
                .andExpect(jsonPath("$..createdDate").value(currentTime.toString()))
                .andExpect(jsonPath("$..modifiedDate").value(currentTime.toString()));


        verify(getDocumentPreviewsUseCase).getDocumentPreviews(searchTerm);
    }

    @Test
    void givenDocumentDoesNotExist_whenFindByTitle_thenReturnsEmptyList() throws Exception {
        Instant currentTime = Instant.now();
        String searchTerm = "markdown";
        DocumentPreview documentPreview = new DocumentPreview(1L, "default document", currentTime, currentTime);

        given(getDocumentPreviewsUseCase.getDocumentPreviews(searchTerm)).willReturn(List.of(documentPreview));

        mockMvc.perform(
                get("/documents/previews?title=" + searchTerm)
                        .accept("application/json")
        ).andExpect(status().isOk());

        verify(getDocumentPreviewsUseCase).getDocumentPreviews(searchTerm);
    }
}
