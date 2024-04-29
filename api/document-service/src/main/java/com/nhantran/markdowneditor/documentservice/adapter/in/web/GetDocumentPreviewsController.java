package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.port.in.DocumentPreview;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentPreviewsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Documents")
public class GetDocumentPreviewsController {
    private final GetDocumentPreviewsUseCase getDocumentPreviewsUseCase;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GetDocumentPreviewsController(GetDocumentPreviewsUseCase getDocumentPreviewsUseCase) {
        this.getDocumentPreviewsUseCase = getDocumentPreviewsUseCase;
    }

    @GetMapping("/documents/previews")
    @Operation(summary = "List all document previews")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DocumentPreview.class)))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    public List<DocumentPreview> getDocumentPreviews(@RequestParam(name = "title", required = false) String documentTitle) {
        logger.debug("title {}", documentTitle);
        return getDocumentPreviewsUseCase.getDocumentPreviews(documentTitle);
    }
}
