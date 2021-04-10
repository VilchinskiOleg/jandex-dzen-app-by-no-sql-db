package com.example.webapplicationboot.rest.model.post;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {

    private String id;
    private String message;
    private String authorId;
    private LocalDateTime createdAt;
}
