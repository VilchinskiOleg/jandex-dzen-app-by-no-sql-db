package com.example.webapplicationboot.persistent.entity.post;

import com.example.webapplicationboot.persistent.entity.post.Comment;
import com.example.webapplicationboot.persistent.entity.post.Like;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    private String title;
    private String massage;
    private String authorId;
    private LocalDateTime createdAt;
    private Like like;
    private Comment comment;
}
