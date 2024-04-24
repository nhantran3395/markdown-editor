package com.nhantran.markdowneditor.documentservice.application.port.in;

import java.time.Instant;

public record DocumentPreview(Long id, String title, Instant createdDate, Instant modifiedDate) {
}
