package com.example.webapplicationboot.rest.model.post;

import com.example.webapplicationboot.persistent.entity.post.Comment;
import com.example.webapplicationboot.persistent.entity.post.Like;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Post {

    private String id;
    private String title;
    private String massage;
    private String authorId;
    private LocalDateTime createdAt;
    private List<Like> likes;
    private List<Comment> comments;
}
