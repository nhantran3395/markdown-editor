package com.nhantran.markdowneditor.documentservice.adapter.in.web;

import com.nhantran.markdowneditor.documentservice.application.domain.model.Document;
import com.nhantran.markdowneditor.documentservice.application.port.in.GetDocumentDetailUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDocumentDetailController implements GetDocumentDetailUseCase {

    @Override
    public Document getDocumentDetail(String documentId) {
        return null;
    }
}
