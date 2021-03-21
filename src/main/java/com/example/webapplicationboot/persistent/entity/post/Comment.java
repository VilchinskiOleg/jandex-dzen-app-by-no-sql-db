package com.example.webapplicationboot.persistent.entity.post;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {

    private String id;
    private String massage;
    private String authorId;
    private LocalDateTime createdAt;
}
