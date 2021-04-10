package com.example.webapplicationboot.rest.model.post;

import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;

@Getter
@Setter
public class PostRequest {

    @Valid
    private Post post;
}
