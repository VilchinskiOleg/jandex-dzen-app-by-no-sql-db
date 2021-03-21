package com.example.webapplicationboot.domain.service.processor;

import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

public interface UpdatePostProcessor {
    ProcessType getProcessType();
    Post process(Post post);

    @Autowired
    default void processRegistration(PostService postService) {
        postService.injectNewProcessor(getProcessType(), this);
    }

    enum ProcessType {
        UPDATE_COMMENT,
        UPDATE_LIKE,
        UPDATE_NAME
    }
}
