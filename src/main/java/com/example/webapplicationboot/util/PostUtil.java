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
        post.setId("123");
        post.setAuthorId("vin76423");
        post.setLike(new Like());
        post.setComment(new Comment());
        post.setCreatedAt(LocalDateTime.now());
        post.setTitle("some_title");
        post.setMassage("some_text");
        return post;
    }
}
