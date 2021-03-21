package com.example.webapplicationboot.persistent.entity.post;

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
