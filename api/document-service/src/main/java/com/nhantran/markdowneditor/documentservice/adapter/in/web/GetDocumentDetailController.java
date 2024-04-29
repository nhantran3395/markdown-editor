package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Tag(name = "Documents")
public class GetDocumentDetailController {

    private final GetDocumentDetailUseCase getDocumentDetailUseCase;

    public GetDocumentDetailController(GetDocumentDetailUseCase getDocumentDetailUseCase) {
        this.getDocumentDetailUseCase = getDocumentDetailUseCase;
    }

    @GetMapping("documents/{documentId}")
    @Operation(summary = "View document detail")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = Document.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
    })
    public ResponseEntity<Document> getDocumentDetail(@PathVariable("documentId") Long documentId) {
        Optional<Document> document = getDocumentDetailUseCase.getDocumentDetail(documentId);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
