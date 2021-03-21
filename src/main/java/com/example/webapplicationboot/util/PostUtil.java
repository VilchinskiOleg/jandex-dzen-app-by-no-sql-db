package com.example.webapplicationboot.util;

import com.example.webapplicationboot.persistent.entity.post.Comment;
import com.example.webapplicationboot.persistent.entity.post.Like;
import com.example.webapplicationboot.persistent.entity.post.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostUtil {

    public static Post getEmptyEntityPost() {
//        Post post = new Post();
//        post.setId(null);
//        post.setAuthorId(null);
//        post.setLikes(new ArrayList<>());
//        post.setComments(new ArrayList<>());
//        post.setCreatedAt(null);
//        post.setTitle(null);
//        post.setMassage(null);
//        return post;

        Post post = new Post();
        post.setAuthorId("vin76423");
        post.setLike(Like.builder()
                .authorId("123-qwe")
                .createdAt(LocalDateTime.now())
                .build());
        post.setComment(Comment.builder()
                .authorId("123-qwe")
                .createdAt(LocalDateTime.now())
                .massage("some message")
                .build());
        post.setCreatedAt(LocalDateTime.now());
        post.setTitle("some_title");
        post.setMassage("some_text");
        return post;
    }
}
