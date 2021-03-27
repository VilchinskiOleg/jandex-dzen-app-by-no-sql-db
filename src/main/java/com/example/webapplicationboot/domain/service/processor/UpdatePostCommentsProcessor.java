package com.example.webapplicationboot.domain.service.processor;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType.UPDATE_COMMENT;

import com.example.webapplicationboot.domain.model.post.Post;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostCommentsProcessor implements UpdatePostProcessor {
    @Override
    public ProcessType getProcessType() {
        return UPDATE_COMMENT;
    }

    @Override
    public Post process(Post post) {
        return null;
    }
}
