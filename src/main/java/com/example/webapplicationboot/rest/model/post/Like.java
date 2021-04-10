package com.example.webapplicationboot.rest.model.post;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Like {

    private String id;
    private String authorId;
    private LocalDateTime createdAt;
}
