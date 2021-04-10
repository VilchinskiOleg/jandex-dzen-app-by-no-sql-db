package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.domain.model.post.Comment;
import com.example.webapplicationboot.domain.model.post.Like;
import com.example.webapplicationboot.persistent.entity.post.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EntityPostToPostConverter extends BaseConverter<Post, com.example.webapplicationboot.domain.model.post.Post> {

    @Override
    protected com.example.webapplicationboot.domain.model.post.Post getDestination() {
        return new com.example.webapplicationboot.domain.model.post.Post();
    }

    @Override
    public void convert(Post source, com.example.webapplicationboot.domain.model.post.Post destination) {
        destination.setComments(mapper.map(source.getComments(), new ArrayList<>(), Comment.class));
        destination.setTitle(source.getTitle());
        destination.setDescription(source.getDescription());
        destination.setCreatedAt(source.getCreatedAt());
        destination.setLikes(mapper.map(source.getLikes(), new ArrayList<>(), Like.class));
        destination.setAuthorId(source.getAuthorId());
    }
}
