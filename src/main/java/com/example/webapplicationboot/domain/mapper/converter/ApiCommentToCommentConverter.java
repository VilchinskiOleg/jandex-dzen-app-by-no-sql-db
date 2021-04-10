package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.rest.model.post.Comment;
import org.springframework.stereotype.Component;

@Component
public class ApiCommentToCommentConverter extends BaseConverter<Comment, com.example.webapplicationboot.domain.model.post.Comment> {

    @Override
    protected com.example.webapplicationboot.domain.model.post.Comment getDestination() {
        return new com.example.webapplicationboot.domain.model.post.Comment();
    }

    @Override
    public void convert(Comment source, com.example.webapplicationboot.domain.model.post.Comment destination) {
        destination.setAuthorId(source.getAuthorId());
        destination.setMassage(source.getMassage());
    }
}
