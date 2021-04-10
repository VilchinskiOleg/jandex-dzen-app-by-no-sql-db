package com.example.webapplicationboot.util;

import static java.util.Collections.singletonList;

import com.example.webapplicationboot.persistent.entity.post.Comment;
import com.example.webapplicationboot.persistent.entity.post.Like;
import com.example.webapplicationboot.persistent.entity.post.Post;
import java.time.LocalDateTime;

public class PostUtil {

    public static Post getMockEntityPost() {
        Post post = new Post();
        post.setAuthorId("vin76423");
        post.setLikes(singletonList(Like.builder()
                .authorId("123-qwe")
                .createdAt(LocalDateTime.now())
                .build()));
        post.setComments(singletonList(Comment.builder()
                .authorId("123-qwe")
                .createdAt(LocalDateTime.now())
                .message("some message")
                .build()));
        post.setCreatedAt(LocalDateTime.now());
        post.setTitle("some_title");
        post.setDescription("some_text");
        return post;
    }
}
