package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.rest.model.post.Like;
import org.springframework.stereotype.Component;

@Component
public class ApiLikeToLikeConverter extends BaseConverter<Like, com.example.webapplicationboot.domain.model.post.Like> {

    @Override
    protected com.example.webapplicationboot.domain.model.post.Like getDestination() {
        return new com.example.webapplicationboot.domain.model.post.Like();
    }

    @Override
    public void convert(Like source, com.example.webapplicationboot.domain.model.post.Like destination) {
        destination.setAuthorId(source.getAuthorId());
    }
}
