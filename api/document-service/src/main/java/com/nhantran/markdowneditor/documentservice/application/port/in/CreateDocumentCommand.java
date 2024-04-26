package com.nhantran.markdowneditor.documentservice.application.port.in;

import jakarta.validation.constraints.NotBlank;

public record CreateDocumentCommand(@NotBlank String title, String content) {
}
