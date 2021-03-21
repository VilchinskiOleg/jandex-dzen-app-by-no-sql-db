package com.example.webapplicationboot.domain.model.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Like {

    private String authorId;
    private LocalDateTime createdAt;
}
