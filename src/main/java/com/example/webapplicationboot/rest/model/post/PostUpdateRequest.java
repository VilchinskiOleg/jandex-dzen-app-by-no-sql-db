package com.example.webapplicationboot.rest.model.post;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;

import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;

public class PostUpdateRequest {
    private Post post;
    private ProcessType processType;

}
