package com.example.webapplicationboot.domain.model.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
