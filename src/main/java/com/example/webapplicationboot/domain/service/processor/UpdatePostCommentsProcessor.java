package com.example.webapplicationboot.domain.service.processor;

import com.example.webapplicationboot.domain.model.post.Post;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostCommentsProcessor implements UpdatePostProcessor {
    @Override
    public ProcessType getProcessType() {
        return null;
    }

    @Override
    public Post process(Post post) {
        return null;
    }
}
