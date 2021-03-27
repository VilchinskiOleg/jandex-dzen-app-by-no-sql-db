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
        destination.setComments(modelMapper.map(source.getComments(), new ArrayList<>(), Comment.class));
        destination.setTitle(source.getTitle());
        destination.setMassage(source.getMassage());
        destination.setCreatedAt(source.getCreatedAt());
        destination.setLikes(modelMapper.map(source.getLikes(), new ArrayList<>(), Like.class));
        destination.setAuthorId(source.getAuthorId());
    }
}
