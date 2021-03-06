package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.persistent.entity.post.Comment;
import org.springframework.stereotype.Component;

@Component
public class EntityCommentToCommentConverter extends BaseConverter<Comment, com.example.webapplicationboot.domain.model.post.Comment> {

    @Override
    protected com.example.webapplicationboot.domain.model.post.Comment getDestination() {
        return new com.example.webapplicationboot.domain.model.post.Comment();
    }

    @Override
    public void convert(Comment source, com.example.webapplicationboot.domain.model.post.Comment destination) {
        destination.setAuthorId(source.getAuthorId());
        destination.setMassage(source.getMassage());
        destination.setCreatedAt(source.getCreatedAt());
    }
}
