package com.example.webapplicationboot.persistent.entity.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "post")
public class Post {

    @Id
    private String id;

    private String title;
    private String description;
    private String authorId;
    private LocalDateTime createdAt;
    private List<Like> likes;
    private List<Comment> comments;
}
