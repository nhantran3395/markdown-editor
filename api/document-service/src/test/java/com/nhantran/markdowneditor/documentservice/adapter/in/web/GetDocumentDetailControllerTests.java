package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GetDocumentDetailController.class)
class GetDocumentDetailControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetDocumentDetailUseCase getDocumentDetailUseCase;

    @Test
    void givenDocumentId_whenGetDocumentDetail_thenReturnDocumentDetail() throws Exception {
        Instant currentTime = Instant.now();
        Document document = new Document(1L, "default document", currentTime, currentTime, "this is a default document");
        given(getDocumentDetailUseCase.getDocumentDetail(1L)).willReturn(Optional.of(document));

        mockMvc.perform(
                        get("/documents/1")
                                .accept("application/json")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("title").value("default document"))
                .andExpect(jsonPath("createdDate").value(currentTime.toString()))
                .andExpect(jsonPath("modifiedDate").value(currentTime.toString()))
                .andExpect(jsonPath("content").value("this is a default document"));
    }

    @Test
    void givenNoneExistingDocumentId_whenGetDocumentDetail_thenReturnNotFound() throws Exception {
        given(getDocumentDetailUseCase.getDocumentDetail(1L)).willReturn(Optional.empty());

        mockMvc.perform(
                get("/documents/1")
                        .accept("application/json")
        ).andExpect(status().isNotFound());
    }
}
