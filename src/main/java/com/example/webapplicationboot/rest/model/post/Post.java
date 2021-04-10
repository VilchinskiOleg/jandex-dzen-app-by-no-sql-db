package com.example.webapplicationboot.rest.model.post;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Post {

    private String id;
    private String title;
    private String description;
    private String authorId;
    private LocalDateTime createdAt;
    private List<Like> likes;
    private List<Comment> comments;
}
