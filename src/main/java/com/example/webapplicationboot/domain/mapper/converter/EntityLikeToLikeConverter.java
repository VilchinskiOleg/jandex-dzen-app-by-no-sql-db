package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.persistent.entity.post.Like;
import org.springframework.stereotype.Component;

@Component
public class EntityLikeToLikeConverter extends BaseConverter<Like, com.example.webapplicationboot.domain.model.post.Like> {

    @Override
    protected com.example.webapplicationboot.domain.model.post.Like getDestination() {
        return new com.example.webapplicationboot.domain.model.post.Like();
    }

    @Override
    public void convert(Like source, com.example.webapplicationboot.domain.model.post.Like destination) {
        destination.setCreatedAt(source.getCreatedAt());
        destination.setAuthorId(source.getAuthorId());
    }
}
