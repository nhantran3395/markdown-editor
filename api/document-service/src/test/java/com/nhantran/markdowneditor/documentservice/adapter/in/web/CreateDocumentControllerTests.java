package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentCommand;
import com.nhantran.markdowneditor.documentservice.application.port.in.CreateDocumentUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CreateDocumentController.class)
class CreateDocumentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CreateDocumentUseCase createDocumentUseCase;

    @Test
    void givenAccessTokenNotProvided_whenCreateDocument_thenReturnsUnauthorized() throws Exception {
        CreateDocumentCommand command = new CreateDocumentCommand("sample", "sample document");

        mockMvc.perform(
                post("/documents/1")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(command))
        ).andExpect(status().isUnauthorized());
    }

    @Test
    void givenMissingTitle_whenCreateDocument_thenReturnsBadRequest() throws Exception {
        CreateDocumentCommand command = new CreateDocumentCommand(null, "sample document");

        mockMvc.perform(
                        post("/documents")
                                .with(SecurityMockMvcRequestPostProcessors.jwt())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(command))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenMissingContent_whenCreateDocument_thenReturnsCreatedStatusCode() throws Exception {
        CreateDocumentCommand command = new CreateDocumentCommand("sample document", null);

        given(createDocumentUseCase.createDocument(command)).willReturn(3L);

        mockMvc.perform(
                        post("/documents")
                                .with(SecurityMockMvcRequestPostProcessors.jwt())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(command))
                )
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/documents/3"));

        verify(createDocumentUseCase).createDocument(command);
    }

    @Test
    void givenMissingBothTitleAndContent_whenCreateDocument_thenReturnsBadRequest() throws Exception {
        CreateDocumentCommand command = new CreateDocumentCommand(null, null);

        mockMvc.perform(
                        post("/documents")
                                .with(SecurityMockMvcRequestPostProcessors.jwt())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(command))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenTitleAndContent_whenCreateDocument_thenReturnsCreatedStatusCode() throws Exception {
        CreateDocumentCommand command = new CreateDocumentCommand("sample document", "this is a sample markdown document");

        given(createDocumentUseCase.createDocument(command)).willReturn(3L);

        mockMvc.perform(
                        post("/documents")
                                .with(SecurityMockMvcRequestPostProcessors.jwt())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(command))
                )
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/documents/3"));

        verify(createDocumentUseCase).createDocument(command);
    }

    protected static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
