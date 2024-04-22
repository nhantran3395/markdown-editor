package com.nhantran.markdowneditor.documentservice.application.port.in;

import java.util.List;

public interface GetDocumentPreviewsUseCase {
    List<DocumentPreview> getDocumentPreviews();
}
